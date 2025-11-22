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
	
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public LocalDateTime getExpireAt() {
		return expireAt;
	}
	public void setExpireAt(LocalDateTime expireAt) {
		this.expireAt = expireAt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(expireAt, originalUrl, shortUrl);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlResponseDto other = (UrlResponseDto) obj;
		return Objects.equals(expireAt, other.expireAt) && Objects.equals(originalUrl, other.originalUrl)
				&& Objects.equals(shortUrl, other.shortUrl);
	}
	@Override
	public String toString() {
		return "UrlResponseDto [shortUrl=" + shortUrl + ", originalUrl=" + originalUrl + ", expireAt=" + expireAt + "]";
	}
	
	
	
}
