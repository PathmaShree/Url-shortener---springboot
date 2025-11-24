package com.example.url.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.url.dto.UrlAnalyticsDto;
import com.example.url.entity.UrlMapping;
import com.example.url.repository.UrlMappingRepository;
import com.example.url.serviceImplementation.UrlAnalyticsServiceImplementation;

@RestController
@RequestMapping("/api/urlAnalytics")
public class UrlAnalyticsController {
	private final UrlAnalyticsServiceImplementation analyticsI;
    private final UrlMappingRepository repo;
	public UrlAnalyticsController(UrlAnalyticsServiceImplementation analyticsI,UrlMappingRepository repo) {
		this.analyticsI = analyticsI;
		this.repo=repo;
	
	}
	
	@GetMapping("/getAll/{shortCode}")
	public ResponseEntity<?> getAllAnalytics(@PathVariable String shortCode){
		try {
			UrlMapping url =repo.findByShortCode(shortCode)
					.orElseThrow(() -> new RuntimeException("URL not found"));
			List<UrlAnalyticsDto> dto =analyticsI.getAnalyticsForUrl(url);
			return new ResponseEntity<List<UrlAnalyticsDto>>(dto,HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/count/{shortCode}")
	public ResponseEntity<?> countVisits(@PathVariable String shortCode){
		try {
			UrlMapping url =repo.findByShortCode(shortCode).orElseThrow(() -> new RuntimeException("URL not found"));
			Long count = analyticsI.countVisits(url);
			return new ResponseEntity<>(count, HttpStatus.OK);
		}
		 catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	}
	
}
