package com.example.url.mapper;

import java.time.LocalDateTime;

import com.example.url.dto.UrlRequestDto;
import com.example.url.dto.UrlResponseDto;
import com.example.url.entity.UrlMapping;

public class UrlMapper {

	public static UrlMapping toEntity(UrlRequestDto dto) {
		UrlMapping entity = new UrlMapping();
		entity.setOriginalUrl(dto.getOriginalUrl());
		 
		if(dto.getExpiryHours()!=null && dto.getExpiryHours()>0) {
			entity.setExpireAt(LocalDateTime.now().plusHours(dto.getExpiryHours()));
		}
		else {
			entity.setExpireAt(null);
		}
		return entity;
	}
	
	public static UrlResponseDto toDto(UrlMapping entity) {
		UrlResponseDto dto = new UrlResponseDto();
		dto.setShortUrl("http://localhost:8085/"+entity.getShortCode());
		dto.setShortCode(entity.getShortCode());
		dto.setOriginalUrl(entity.getOriginalUrl());
		dto.setExpireAt(entity.getExpireAt());
		return dto;
	}
	  
}
