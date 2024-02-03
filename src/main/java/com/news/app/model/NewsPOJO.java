package com.news.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewsPOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public NewsPOJO(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public NewsPOJO() {
		
	}
	@Override
	public String toString() {
		return "NewsPOJO [title=" + title + ", content=" + content + "]";
	}
	
}
