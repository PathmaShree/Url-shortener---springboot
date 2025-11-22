package com.example.url.service;

import java.util.List;

import com.example.url.dto.UrlAnalyticsDto;
import com.example.url.entity.UrlAnalytics;
import com.example.url.entity.UrlMapping;

public interface UrlAnalyticsService {

	UrlAnalytics logAccess(UrlAnalytics analytics);
	List<UrlAnalyticsDto> getAnalyticsForUrl(UrlMapping mapping);
	Long countVisits(UrlMapping mapping);
}
