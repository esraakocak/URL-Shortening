package com.project.urlShortening.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name ="url")
public class Url {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column (name ="id")
	    private int id;
	    
	    
	    @Column(name ="original_url")
	    private String originalUrl;
	    
	    @Column(name="short_link")
	    private String shortLink;
	    
	    @Column(name="creation_date")
	    private LocalDateTime creationDate;
	    
	    @Column(name="expiration_date")
	    private LocalDateTime expirationDate;


	
	}
