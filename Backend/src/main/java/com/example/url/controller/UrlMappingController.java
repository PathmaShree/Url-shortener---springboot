package com.example.url.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.url.dto.ExpiryUpdateDto;
import com.example.url.dto.UrlAnalyticsDto;
import com.example.url.dto.UrlRequestDto;
import com.example.url.dto.UrlResponseDto;
import com.example.url.serviceImplementation.UrlServiceImplementation;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/urlMapping")
public class UrlMappingController {

	private final UrlServiceImplementation urlI;
	public UrlMappingController( UrlServiceImplementation urlI) {
		this.urlI=urlI;
	}
	
	@PostMapping("/createShorten")
	public ResponseEntity<?> createShortUrl(@RequestBody UrlRequestDto dto){
		try {
		UrlResponseDto shortUrl = urlI.createShortUrl(dto);
		return new ResponseEntity<UrlResponseDto>(shortUrl,HttpStatus.CREATED);
	}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/redirect/{shortCode}")
	public ResponseEntity<?> redirectUrl(@PathVariable String shortCode,HttpServletRequest request){
		try {
			String originalUrl = urlI.getOriginalUrl(shortCode, request);
			return new ResponseEntity<>(originalUrl,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAnalytics/{shortCode}")
	public ResponseEntity<?>getAnalytics(@PathVariable String shortCode){
		try {
			List<UrlAnalyticsDto> analytics = urlI.getAnalytics(shortCode);
			return new ResponseEntity<List<UrlAnalyticsDto>>(analytics,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			UrlResponseDto byId = urlI.getById(id);
			return new ResponseEntity<UrlResponseDto>(byId,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUrls(){
		try {
			List<UrlResponseDto> allUrls = urlI.getAllUrls();
			return new ResponseEntity<List<UrlResponseDto>>(allUrls,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateExpiry(@PathVariable Long id,@RequestBody ExpiryUpdateDto dto){
		try {
			UrlResponseDto update = urlI.update(id, dto);
			return new ResponseEntity<UrlResponseDto>(update,HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		try {
			urlI.deleteUrl(id);
			return new ResponseEntity<>("URL deleted successfully",HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
