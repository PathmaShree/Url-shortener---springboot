package com.example.url.service;

import java.util.List;

import com.example.url.dto.ExpiryUpdateDto;
import com.example.url.dto.UrlAnalyticsDto;
import com.example.url.dto.UrlRequestDto;
import com.example.url.dto.UrlResponseDto;


import jakarta.servlet.http.HttpServletRequest;

public interface UrlService {

	UrlResponseDto createShortUrl(UrlRequestDto dto);
	String getOriginalUrl(String shortCode,HttpServletRequest request);
	List<UrlAnalyticsDto> getAnalytics(String shortCode);
	
	
	UrlResponseDto getById(Long id);
	List<UrlResponseDto> getAllUrls();
    UrlResponseDto update(Long id,ExpiryUpdateDto dto);
    void deleteUrl(Long id);
	
	
}
