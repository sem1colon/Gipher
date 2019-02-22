package com.stackroute.giphermanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.giphermanager.domain.Gif;

@Repository
public interface GifRepository extends JpaRepository<Gif, Integer> {

	Optional<Gif> findByGifIdAndUserId(String gifId, String userId);

	List<Gif> findByUserIdAndBookmark(String userId, boolean bookmark);

	List<Gif> findByUserIdAndFavourite(String userId, boolean favourite);

}
