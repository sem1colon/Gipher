package com.stackroute.giphermanager.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.giphermanager.domain.Gif;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class GifRepositoryTest {

	private transient GifRepository repo;

	@Autowired
	public void setRepo(GifRepository repo) {
		this.repo = repo;
	}

	@Test
	public void testSaveGif() throws Exception {
		repo.save(new Gif("3Qumr2SLqrl5e", "tom and jerry", "https://media3.giphy.com/media/j5HVafHBMYnss/giphy.gif",
				"https://media3.giphy.com/media/j5HVafHBMYnss/giphy-preview.gif", true, true, "sem1colon"));
		final Gif gif = repo.getOne(1);
		assertThat(gif.getId()).isEqualTo(1);
	}

	@Test
	public void testDeleteGif() throws Exception {
		Gif gif = new Gif(1, "3Qumr2SLqrl5e", "tom and jerry", "https://media3.giphy.com/media/j5HVafHBMYnss/giphy.gif",
				"https://media3.giphy.com/media/j5HVafHBMYnss/giphy-preview.gif", true, true, "sem1colon");
		repo.save(gif);
		assertEquals("tom and jerry", gif.getTitle());
		repo.delete(gif);
		assertEquals(Optional.empty(), repo.findById(1));
	}
}
