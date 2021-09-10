package com.project.urlShortening.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;


import java.time.LocalDateTime;


@Data
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

	
	    public Url(int id, String originalUrl, String shortLink, LocalDateTime creationDate, LocalDateTime expirationDate) {
	        this.id = id;
	        this.originalUrl = originalUrl;
	        this.shortLink = shortLink;
	        this.creationDate = creationDate;
	        this.expirationDate = expirationDate;
	    }

	    public Url() {
	    }

	   

	    @Override
	    public String toString() {
	        return "Url{" +
	                "id=" + id +
	                ", originalUrl='" + originalUrl + '\'' +
	                ", shortLink='" + shortLink + '\'' +
	                ", creationDate=" + creationDate +
	                ", expirationDate=" + expirationDate +
	              
	                '}';
	    }
	}
