package com.example.url.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponseDto {

	private String shortUrl;
	private String originalUrl;
	private LocalDateTime expireAt;
	private String shortCode;
	
	
}
