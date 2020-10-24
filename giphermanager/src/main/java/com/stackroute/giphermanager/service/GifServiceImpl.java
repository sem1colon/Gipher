package com.stackroute.giphermanager.service;

import com.stackroute.giphermanager.domain.Gif;
import com.stackroute.giphermanager.exception.BookmarkAlreadyExistsException;
import com.stackroute.giphermanager.exception.BookmarkNotFoundException;
import com.stackroute.giphermanager.exception.FavouriteAlreadyExitsException;
import com.stackroute.giphermanager.exception.FavouriteNotFoundException;
import com.stackroute.giphermanager.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifServiceImpl implements GifService {

	private final transient GifRepository gifRepository;

	@Autowired
	public GifServiceImpl(GifRepository gifRepository) {
		super();
		this.gifRepository = gifRepository;
	}

	@Override
	public boolean saveGif(Gif gif, String operationType)
			throws BookmarkAlreadyExistsException, FavouriteAlreadyExitsException {
		Gif object = gifRepository.findByGifIdAndUserId(gif.getGifId(), gif.getUserId()).orElse(null);
		if (object != null) {
			if (operationType.equals("bookmark")) {
				if (object.isBookmark()) {
					throw new BookmarkAlreadyExistsException("Gif already exists in bookmarks!");
				}
				object.setBookmark(true);
			} else {
				if (object.isFavourite()) {
					throw new FavouriteAlreadyExitsException("Gif already exists in favourites!");
				}
				object.setFavourite(true);
			}
		} else {
			object = gif;
			object.setUserId(gif.getUserId());
			if (operationType.equals("bookmark")) {
				object.setBookmark(true);
			} else {
				object.setFavourite(true);
			}
		}
		gifRepository.save(object);
		return true;
	}

	@Override
	public boolean deleteGif(Gif gif, String operationType)
			throws BookmarkNotFoundException, FavouriteNotFoundException {
		Gif object = gifRepository.findByGifIdAndUserId(gif.getGifId(), gif.getUserId()).orElse(null);
		if (operationType.equals("bookmark")) {
			if (object.isBookmark()) {
				object.setBookmark(false);
			} else {
				throw new BookmarkNotFoundException("Bookmarked Gif not exits!");
			}
		} else {
			if (object.isFavourite()) {
				object.setFavourite(false);
			} else {
				throw new FavouriteNotFoundException("Favouritex Gif not exists!");
			}
		}
		if (!object.isBookmark() && !object.isFavourite()) {
			gifRepository.delete(object);
		} else {
			gifRepository.save(object);
		}
		return true;
	}

	@Override
	public List<Gif> getBookmarks(String userId) {
		return gifRepository.findByUserIdAndBookmark(userId, true);
	}

	@Override
	public List<Gif> getFavourites(String userId) {
		return gifRepository.findByUserIdAndFavourite(userId, true);
	}

}
