package com.news.app.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.app.model.NewsPOJO;
import com.news.app.repo.NewsPostRepo;

@Service
public class NewsSearchService {
	
	@Autowired
	NewsPostRepo newsPostRepo;
	
	public List<NewsPOJO> getSearchedInfo(String search){
		
		return newsPostRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(search, search);
	}

}
