package com.project.urlShortening.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.urlShortening.model.Url;

public interface UrlRepository extends JpaRepository<Url, Integer>{
  
	  public Url findByShortLink(String shortLink);
}
