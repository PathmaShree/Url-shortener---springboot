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
@NoArgsConstructor
@AllArgsConstructor
public class UrlAnalyticsDto {

	private LocalDateTime accessTime;
	private String ipAdress;
	private String browser;
	private String os;
	private String deviceType;
	private String referrer;
	private String country;	
}
