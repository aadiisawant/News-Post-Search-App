package com.news.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.app.model.NewsPOJO;
import com.news.app.repo.service.NewsSearchService;

@RestController
@RequestMapping("news-api")
public class NewsController {

	@Autowired
	NewsSearchService newsSearchService;
	
	@GetMapping("/search")
	public List<NewsPOJO> getSearchedContent(@RequestParam String search){
		System.out.println("In Search block");
		return newsSearchService.getSearchedInfo(search);
	}
	
	@PostMapping("/addpost")
	public String addNewsPost(@RequestBody NewsPOJO newsPOJO) {
		System.out.println("In addPost block");
		newsSearchService.saveData(newsPOJO);
		return "Data Added";
	}
	@PostMapping("/addposts")
	public String addNewsPosts(@RequestBody List<NewsPOJO> newsPOJO) {
		System.out.println("In addPost block");
		newsSearchService.saveAllPosts(newsPOJO);
		return "Data Added";
	}
}
