package com.stackroute.giphermanager.service;

import com.stackroute.giphermanager.domain.Search;

public interface SearchService {
	
	/**Method declaration for saving search
	 * 
	 * @param search
	 * @return status(true/false)
	 */
	boolean saveSearch(Search search);
}
