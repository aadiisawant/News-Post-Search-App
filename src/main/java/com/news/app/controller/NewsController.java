package com.news.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.app.model.NewsPOJO;
import com.news.app.repo.service.NewsSearchService;

@RestController
public class NewsController {

	@Autowired
	NewsSearchService newsSearchService;
	
	@GetMapping("/search/{}")
	public List<NewsPOJO> getSearchedContent(@RequestParam String search){
		
		return newsSearchService.getSearchedInfo(search);
	}
}
