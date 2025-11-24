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
	
	
}
