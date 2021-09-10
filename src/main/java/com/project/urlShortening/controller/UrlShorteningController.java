package com.project.urlShortening.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.urlShortening.model.Url;
import com.project.urlShortening.model.UrlDto;
import com.project.urlShortening.model.UrlErrorResponseDto;
import com.project.urlShortening.model.UrlResponseDto;
import com.project.urlShortening.service.UrlService;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UrlShorteningController {
	 
	@Autowired
	 UrlService urlService;
	
	  @PostMapping("/generate")
	    public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto)
	    {
	        Url urlToRet = urlService.generateShortLink(urlDto);

	        if(urlToRet != null) 
	        {
	            UrlResponseDto urlResponseDto = new UrlResponseDto();
	            urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
	            urlResponseDto.setExpirationDate(urlToRet.getExpirationDate());
	            urlResponseDto.setShortLink(urlToRet.getShortLink());
	            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
	        }

	        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
	        urlErrorResponseDto.setStatus("404");
	        urlErrorResponseDto.setError("There was an error processing your request. please try again.");
	        return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);

	    }

	    @GetMapping("/{shortLink}")
	    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {
  
	        Url urlToRet = urlService.getEncodedUrl(shortLink);

	       response.sendRedirect(urlToRet.getOriginalUrl());
	        return new ResponseEntity<UrlResponseDto>(HttpStatus.OK);
	     
	    }
}
