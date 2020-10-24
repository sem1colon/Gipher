package com.stackroute.giphermanager.repository;

import com.stackroute.giphermanager.domain.Gif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GifRepository extends JpaRepository<Gif, Integer> {

	Optional<Gif> findByGifIdAndUserId(String gifId, String userId);

	List<Gif> findByUserIdAndBookmark(String userId, boolean bookmark);

	List<Gif> findByUserIdAndFavourite(String userId, boolean favourite);

}
