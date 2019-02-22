package com.stackroute.giphermanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.giphermanager.domain.Search;
import com.stackroute.giphermanager.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService {
	public final transient SearchRepository searchRepository;

	@Autowired
	public SearchServiceImpl(SearchRepository searchRepository) {
		super();
		this.searchRepository = searchRepository;
	}

	@Override
	public boolean saveSearch(Search search) {
		searchRepository.save(search);
		return true;
	}
}
