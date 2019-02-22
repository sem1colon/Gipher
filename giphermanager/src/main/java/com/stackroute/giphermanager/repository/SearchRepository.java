package com.stackroute.giphermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.giphermanager.domain.Search;

@Repository
public interface SearchRepository extends JpaRepository<Search, Integer> {

}
