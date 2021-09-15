package com.project.urlShortening.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlResponseDto {
	   private String originalUrl;
	    private String shortLink;
	    private LocalDateTime expirationDate;



} 
