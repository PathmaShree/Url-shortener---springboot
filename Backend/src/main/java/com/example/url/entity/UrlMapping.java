package com.example.url.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name="URL_MAPPING")
public class UrlMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="URL_ID")
	private Long id;
	
	@Column(name="ORIGINAL_URL",nullable=false)
	private String originalUrl;
	
	@Column(name="SHORT_CODE",unique=true)
	private String shortCode;
	
	@CreationTimestamp
	@Column(name="CREATED_AT",updatable=false)
	private LocalDateTime createdAt;
	
	@Column(name="EXPIRE_AT")
	private LocalDateTime expireAt;
	
	@OneToMany(mappedBy = "urlMapping", cascade = CascadeType.ALL)
    private List<UrlAnalytics> analytics = new ArrayList<>();

	

	public List<UrlAnalytics> getAnalytics() {
		return analytics;
	}

	public void setAnalytics(List<UrlAnalytics> analytics) {
		this.analytics = analytics;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(LocalDateTime expireAt) {
		this.expireAt = expireAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, expireAt, id, originalUrl, shortCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlMapping other = (UrlMapping) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(expireAt, other.expireAt)
				 && Objects.equals(id, other.id)
				&& Objects.equals(originalUrl, other.originalUrl) && Objects.equals(shortCode, other.shortCode);
	}

	@Override
	public String toString() {
		return "UrlMapping [id=" + id + ", originalUrl=" + originalUrl + ", shortCode=" + shortCode + ", createdAt="
				+ createdAt + ", expireAt=" + expireAt + ", expiryHours=]";
	}
	
	
	
}
