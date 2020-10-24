package com.stackroute.giphermanager.repository;

import com.stackroute.giphermanager.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Search, Integer> {

}
