package com.example.url.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.url.dto.UrlAnalyticsDto;
import com.example.url.entity.UrlAnalytics;

public class UrlAnalyticsMapper {

	public static UrlAnalyticsDto toDto(UrlAnalytics entity) {
		UrlAnalyticsDto dto= new UrlAnalyticsDto();
		dto.setAccessTime(entity.getAccessTime());
		dto.setIpAdress(entity.getIpAddress());
		dto.setBrowser(entity.getBrowser());
		dto.setOs(entity.getOs());
		dto.setDeviceType(entity.getDeviceType());
		dto.setReferrer(entity.getReferrer());
		dto.setCountry(entity.getCountry());
		return dto;
	}
	
	public static List<UrlAnalyticsDto> toDtoList(List<UrlAnalytics> entity){
		return entity.stream()
				.map(UrlAnalyticsMapper::toDto)
				.collect(Collectors.toList());
	}
}
