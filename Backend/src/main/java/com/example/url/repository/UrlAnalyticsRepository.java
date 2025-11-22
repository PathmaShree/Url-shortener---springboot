package com.example.url.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.url.entity.UrlAnalytics;
import com.example.url.entity.UrlMapping;

public interface UrlAnalyticsRepository extends JpaRepository<UrlAnalytics,Long> {

	List<UrlAnalytics>findByUrlMapping(UrlMapping urlMapping);
	long countByUrlMapping(UrlMapping urlMapping);
}
