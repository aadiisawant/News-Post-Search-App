package com.news.app.repo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.news.app.model.NewsPOJO;
import com.news.app.repo.NewsPostRepo;

@Service
public class NewsSearchService {
	
	@Autowired
	NewsPostRepo newsPostRepo;
	
	public ResponseEntity<List<NewsPOJO>> getSearchedInfo(String search){
		try {
		return new ResponseEntity<>(newsPostRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(search, search), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> saveData(NewsPOJO newsPOJO) {
		System.out.println("In Service Class, save Data");
	try {
		newsPostRepo.save(newsPOJO);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return new ResponseEntity<>("Not Added", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> saveAllPosts(List<NewsPOJO> newsPOJO) {
		try {
			newsPostRepo.saveAll(newsPOJO);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
	}

	
}
