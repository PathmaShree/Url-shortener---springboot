package com.example.url.serviceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.url.dto.UrlAnalyticsDto;
import com.example.url.entity.UrlAnalytics;
import com.example.url.entity.UrlMapping;
import com.example.url.mapper.UrlAnalyticsMapper;
import com.example.url.repository.UrlAnalyticsRepository;
import com.example.url.service.UrlAnalyticsService;


@Service
public class UrlAnalyticsServiceImplementation implements UrlAnalyticsService{

	private final UrlAnalyticsRepository repo;
	public UrlAnalyticsServiceImplementation(UrlAnalyticsRepository repo) {
		this.repo= repo;
	}
	@Override
	public UrlAnalytics logAccess(UrlAnalytics analytics) {
		// TODO Auto-generated method stub
		return repo.save(analytics);
	}
	@Override
	public List<UrlAnalyticsDto> getAnalyticsForUrl(UrlMapping mapping) {
		// TODO Auto-generated method stub
		List<UrlAnalytics> byUrlMapping = repo.findByUrlMapping(mapping);
		return UrlAnalyticsMapper.toDtoList(byUrlMapping);
	}
	@Override
	public Long countVisits(UrlMapping mapping) {
		// TODO Auto-generated method stub
		return repo.countByUrlMapping(mapping);
	}
}
