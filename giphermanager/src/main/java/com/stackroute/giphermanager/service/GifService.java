package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.domain.Gif;
import com.stackroute.giphermanager.exception.BookmarkAlreadyExistsException;
import com.stackroute.giphermanager.exception.FavouriteAlreadyExitsException;
import com.stackroute.giphermanager.exception.FavouriteNotFoundException;
import com.stackroute.giphermanager.exception.BookmarkNotFoundException;

public interface GifService {

	/**
	 * Method declaration for adding bookmark/favourite
	 * 
	 * @param gif
	 * @param        operationType(bookmark/favourite)
	 * @return
	 * @throws BookmarkAlreadyExistsException
	 * @throws FavouriteAlreadyExitsException
	 */
	boolean saveGif(Gif gif, String operationType)
			throws BookmarkAlreadyExistsException, FavouriteAlreadyExitsException;

	/**
	 * Method declaration for removing bookmark/favourite
	 * 
	 * @param gif
	 * @param        operationType(bookmark/favourite)
	 * @return
	 * @throws BookmarkNotFoundException
	 * @throws FavouriteNotFoundException
	 */
	boolean deleteGif(Gif gif, String operationType)
			throws BookmarkNotFoundException, FavouriteNotFoundException;

	/**
	 * Method declaration for getting favourites
	 * 
	 * @param userId
	 * @return Gifs
	 */
	List<Gif> getBookmarks(String userId) throws BookmarkNotFoundException;

	/**
	 * Method declaration for getting bookmarks
	 * 
	 * @param userId
	 * @return Gifs
	 */
	List<Gif> getFavourites(String userId) throws FavouriteNotFoundException;

}
