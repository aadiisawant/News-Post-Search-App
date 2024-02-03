package com.news.app.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.app.model.NewsPOJO;

@Repository
public interface NewsPostRepo extends JpaRepository<NewsPOJO, Long>{

	public List<NewsPOJO> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title,String content);
}
