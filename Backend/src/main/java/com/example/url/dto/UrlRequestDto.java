package com.example.url.dto;

import java.util.Objects;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

public class UrlRequestDto {

	@NotBlank(message="Url cannot be blank")
	@Pattern(regexp = "^(http|https)://.+$", message = "URL must start with http:// or https://")
	private String originalUrl;
    @Min(value = 1, message = "Minimum expiry is 1 hour")
    @Max(value = 24 * 365, message = "Maximum expiry is 1 year (hours)")
    private Integer expiryHours;
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public Integer getExpiryHours() {
		return expiryHours;
	}
	public void setExpiryHours(Integer expiryHours) {
		this.expiryHours = expiryHours;
	}
	@Override
	public int hashCode() {
		return Objects.hash(expiryHours, originalUrl);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlRequestDto other = (UrlRequestDto) obj;
		return Objects.equals(expiryHours, other.expiryHours) && Objects.equals(originalUrl, other.originalUrl);
	}
	@Override
	public String toString() {
		return "UrlRequestDto [originalUrl=" + originalUrl + ", expiryHours=" + expiryHours + "]";
	}

	
}
