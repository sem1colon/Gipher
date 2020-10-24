package com.stackroute.giphermanager.controller;

import com.stackroute.giphermanager.domain.Gif;
import com.stackroute.giphermanager.domain.Search;
import com.stackroute.giphermanager.exception.BookmarkAlreadyExistsException;
import com.stackroute.giphermanager.exception.BookmarkNotFoundException;
import com.stackroute.giphermanager.exception.FavouriteAlreadyExitsException;
import com.stackroute.giphermanager.exception.FavouriteNotFoundException;
import com.stackroute.giphermanager.service.GifService;
import com.stackroute.giphermanager.service.SearchService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gifservice")
@CrossOrigin
public class GifController {

	private static final String SECRETKEY = "cognizant";

	ResponseEntity<?> responseEntity;

	@Autowired
	private GifService gifService;

	@Autowired
	private SearchService searchService;

	@GetMapping(path = "/gif/search/{query}")
	public ResponseEntity<?> findGifsByKeyword(@PathVariable("query") final String keyword,
			final HttpServletRequest request, final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
		Search search = new Search(keyword, userId);
		try {
			searchService.saveSearch(search);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping("/gif/bookmark")
	public ResponseEntity<?> addToBookmarks(@RequestBody final Gif gif, final HttpServletRequest request,
			final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
		gif.setUserId(userId);
		try {
			responseEntity = new ResponseEntity<>(gifService.saveGif(gif, "bookmark"), HttpStatus.CREATED);
		} catch (BookmarkAlreadyExistsException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (FavouriteAlreadyExitsException e) {
			responseEntity = null;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping("/gif/favourite")
	public ResponseEntity<?> addToFavourites(@RequestBody final Gif gif, final HttpServletRequest request,
			final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
		gif.setUserId(userId);
		try {
			responseEntity = new ResponseEntity<>(gifService.saveGif(gif, "favourite"), HttpStatus.CREATED);
		} catch (FavouriteAlreadyExitsException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (BookmarkAlreadyExistsException e) {
			responseEntity = null;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping("/gif/removebookmark")
	public ResponseEntity<?> removeFromBookmarks(@RequestBody final Gif gif, final HttpServletRequest request,
			final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
		gif.setUserId(userId);
		try {
			responseEntity = new ResponseEntity<>(gifService.deleteGif(gif, "bookmark"), HttpStatus.OK);
		} catch (BookmarkNotFoundException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (FavouriteNotFoundException e) {
			responseEntity = null;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping("/gif/removefavourite")
	public ResponseEntity<?> removeFromFavourites(@RequestBody final Gif gif, final HttpServletRequest request,
			final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
		gif.setUserId(userId);
		try {
			responseEntity = new ResponseEntity<>(gifService.deleteGif(gif, "favourite"), HttpStatus.OK);
		} catch (FavouriteNotFoundException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (BookmarkNotFoundException e) {
			responseEntity = null;
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/gif/bookmarks")
	public ResponseEntity<?> fetchBookmarks(final HttpServletRequest request, final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
		try {
			responseEntity = new ResponseEntity<List<Gif>>(gifService.getBookmarks(userId), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/gif/favourites")
	public ResponseEntity<?> fetchFavourites(final HttpServletRequest request, final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody().getSubject();
		try {
			responseEntity = new ResponseEntity<List<Gif>>(gifService.getFavourites(userId), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
