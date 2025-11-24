package com.example.url.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name="URL_ANALYTICS")
public class UrlAnalytics {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ANALYTICS_ID")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="url_id",nullable=false)
	private UrlMapping urlMapping;
	
	@CreationTimestamp
	private LocalDateTime accessTime;
	
	@Column(name="IP_ADDRESS")
	private String ipAddress;
	
	@Column(name="BROWSER")
	private String browser;
	
	@Column(name="OS")
	private String os;
	
	@Column(name="DEVICE_TYPE")
	private String deviceType;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="REFERRER")
	private String referrer;
	
	
}
