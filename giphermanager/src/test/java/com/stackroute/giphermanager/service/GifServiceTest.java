package com.stackroute.giphermanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.giphermanager.domain.Gif;
import com.stackroute.giphermanager.repository.GifRepository;

public class GifServiceTest {
	@Mock
	private transient GifRepository gifRepo;

	private transient Gif gif;

	@InjectMocks
	private transient GifServiceImpl gifServiceImpl;

	transient Optional<Gif> options;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		gif = new Gif("3Qumr2SLqrl5e", "tom and jerry", "https://media3.giphy.com/media/j5HVafHBMYnss/giphy.gif",
				"https://media3.giphy.com/media/j5HVafHBMYnss/giphy-preview.gif", true, true, "sem1colon");
		options = Optional.of(gif);
	}

	@Test
	public void getFavouritesTest() {
//		final List<Gif> gifs = new ArrayList<>();
//		gifs.add(gif);
//		when(gifRepo.findByUserIdAndBookmark("sem1colon", true)).thenReturn(gifs);
//		final List<Gif> gif1 = gifServiceImpl.getFavourites("sem1colon");
//		assertEquals(gifs, gif1);
//		verify(gifRepo, times(1)).findByUserIdAndBookmark("sem1colon", true);
	}

	@Test
	public void getBookmarksTest() {

	}

	@Test
	public void deleteGifTest() {

	}

	@Test
	public void saveGifTest() {

	}
}
