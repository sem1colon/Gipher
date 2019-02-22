package com.stackroute.giphermanager.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.giphermanager.domain.Gif;
import com.stackroute.giphermanager.domain.Search;
import com.stackroute.giphermanager.service.GifService;
import com.stackroute.giphermanager.service.SearchService;

@RunWith(SpringRunner.class)
@WebMvcTest(GifController.class)
public class GifControllerTest {

	@Autowired
	private transient MockMvc mvc;

	@InjectMocks
	private GifController controller;

	@MockBean
	private transient GifService gifService;

	@MockBean
	private transient SearchService searchService;

	private transient Gif gif;

	private transient Search search;

	private static String token;

	private static List<Gif> gifs;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		gifs = new ArrayList<>();
		gif = new Gif("3Qumr2SLqrl5e", "tom and jerry", "https://media3.giphy.com/media/j5HVafHBMYnss/giphy.gif",
				"https://media3.giphy.com/media/j5HVafHBMYnss/giphy-preview.gif", true, true);
		gifs.add(gif);
		gif = new Gif("jgsgghwit", "tom & jerry", "https://media0.giphy.com/media/13Qumr2SLqrl5e/giphy.gif",
				"https://media0.giphy.com/media/13Qumr2SLqrl5e/giphy-preview.gif", true, true);
		gifs.add(gif);
		search = new Search("dhoni", "sem1colon");
		token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJzZW0xY29sb24iLCJpYXQiOjE1NTA3ODM3NjZ9.bjgzmTxDp1BIT3EYPWkHhvpqDrXkYiL4LqrTL1PCND8pN0buPEULYFnSZaEyadLy";
	}

	@Test
	public void removeFromBookmarksTest() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJzZW0xY29sb24iLCJpYXQiOjE1NTA3Mjk0MTd9.CoQdGxPwH5aD9rUQoJgyaITfV0Nuy7enyDRaNesq7VZb-bcdITFMewh_7jLo3_9T";
		when(gifService.deleteGif(gif, "bookmark")).thenReturn(true);
		mvc.perform(post("/api/v1/gifservice/gif/removebookmark").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(gif))).andExpect(status().isOk());
		verify(gifService, times(1)).deleteGif(Mockito.any(Gif.class), Mockito.eq("bookmark"));
		verifyNoMoreInteractions(gifService);
	}

	@Test
	public void removeFromFavouritesTest() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJzZW0xY29sb24iLCJpYXQiOjE1NTA3Mjk0MTd9.CoQdGxPwH5aD9rUQoJgyaITfV0Nuy7enyDRaNesq7VZb-bcdITFMewh_7jLo3_9T";
		when(gifService.deleteGif(gif, "favourite")).thenReturn(true);
		mvc.perform(post("/api/v1/gifservice/gif/removefavourite").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(gif))).andExpect(status().isOk());
		verify(gifService, times(1)).deleteGif(Mockito.any(Gif.class), Mockito.eq("favourite"));
		verifyNoMoreInteractions(gifService);
	}

	@Test
	public void addToBookmarksTest() throws Exception {
		when(gifService.saveGif(gif, "bookmark")).thenReturn(true);
		mvc.perform(post("/api/v1/gifservice/gif/bookmark").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(gif))).andExpect(status().isCreated());
		verify(gifService, times(1)).saveGif(Mockito.any(Gif.class), Mockito.eq("bookmark"));
		verifyNoMoreInteractions(gifService);
	}

	@Test
	public void addToFavouritesTest() throws Exception {
		when(gifService.saveGif(gif, "favourite")).thenReturn(true);
		mvc.perform(post("/api/v1/gifservice/gif/favourite").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(gif))).andExpect(status().isCreated());
		verify(gifService, times(1)).saveGif(Mockito.any(Gif.class), Mockito.eq("favourite"));
		verifyNoMoreInteractions(gifService);
	}

	@Test
	public void fetchFavouritesTest() throws Exception {
		when(gifService.getFavourites("sem1colon")).thenReturn(null);
		mvc.perform(get("/api/v1/gifservice/gif/favourites").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(gif))).andExpect(status().isOk());
		verify(gifService, times(1)).getFavourites("sem1colon");
		verifyNoMoreInteractions(gifService);
	}

	@Test
	public void fetchBookmarksTest() throws Exception {
		when(gifService.getBookmarks("sem1colon")).thenReturn(null);
		mvc.perform(get("/api/v1/gifservice/gif/bookmarks").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(gif))).andExpect(status().isOk());
		verify(gifService, times(1)).getBookmarks("sem1colon");
		verifyNoMoreInteractions(gifService);
	}

	@Test
	public void findGifsByKeywordTest() throws Exception {
		when(searchService.saveSearch(search)).thenReturn(true);
		mvc.perform(get("/api/v1/gifservice/gif/search/{query}", "dhoni").header("authorization", "Bearer " + token))
				.andExpect(status().isOk());
		verify(searchService, times(1)).saveSearch((Mockito.any(Search.class)));
		verifyNoMoreInteractions(searchService);
	}

	private String jsonToString(final Object object) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			result = "Json processing error";
		}
		return result;
	}
}
