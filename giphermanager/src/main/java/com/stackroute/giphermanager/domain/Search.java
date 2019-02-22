package com.stackroute.giphermanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "search")
public class Search {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "keyword")
	private String keyword;

	@Column(name = "user_id")
	private String userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Search() {
		super();
	}

	public Search(String keyword, String userId) {
		super();
		this.keyword = keyword;
		this.userId = userId;
	}

	public Search(int id, String keyword, String userId) {
		super();
		this.id = id;
		this.keyword = keyword;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Search [id=" + id + ", keyword=" + keyword + "]";
	}

}
