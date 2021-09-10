package com.project.urlShortening.service;

import org.springframework.stereotype.Service;

import com.project.urlShortening.model.Url;
import com.project.urlShortening.model.UrlDto;

@Service
public interface UrlService {
	
	  public Url generateShortLink(UrlDto urlDto);
	    public Url persistShortLink(Url url);
	    public Url getEncodedUrl(String url);
	    public  void  deleteShortLink(Url url);

}
