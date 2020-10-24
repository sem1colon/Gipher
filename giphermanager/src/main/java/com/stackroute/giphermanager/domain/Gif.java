package com.stackroute.giphermanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "gif")
public class Gif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "gifId")
	private String gifId;

	@Column(name = "title")
	private String title;

	@Column(name = "preview")
	private String preview;

	@Column(name = "original")
	private String original;

	@Column(name = "bookmark")
	private boolean bookmark;

	@Column(name = "favourite")
	private boolean favourite;

	@Column(name = "user_id")
	private String userId;

	public Gif() {
		super();
	}

	public Gif(String gifId, String title, String preview, String original, boolean bookmark, boolean favourite) {
		super();
		this.gifId = gifId;
		this.title = title;
		this.preview = preview;
		this.original = original;
		this.bookmark = bookmark;
		this.favourite = favourite;
	}

	public Gif(String gifId, String title, String preview, String original, boolean bookmark, boolean favourite,
			String userId) {
		super();
		this.gifId = gifId;
		this.title = title;
		this.preview = preview;
		this.original = original;
		this.bookmark = bookmark;
		this.favourite = favourite;
		this.userId = userId;
	}

	public Gif(int id, String gifId, String title, String preview, String original, boolean bookmark, boolean favourite,
			String userId) {
		super();
		this.id = id;
		this.gifId = gifId;
		this.title = title;
		this.preview = preview;
		this.original = original;
		this.bookmark = bookmark;
		this.favourite = favourite;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGifId() {
		return gifId;
	}

	public void setGifId(String gifId) {
		this.gifId = gifId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public boolean isBookmark() {
		return bookmark;
	}

	public void setBookmark(boolean bookmark) {
		this.bookmark = bookmark;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Gif [id=" + id + ", gifId=" + gifId + ", title=" + title + ", preview=" + preview + ", original="
				+ original + ", bookmark=" + bookmark + ", favourite=" + favourite + ", userId=" + userId + "]";
	}

}
