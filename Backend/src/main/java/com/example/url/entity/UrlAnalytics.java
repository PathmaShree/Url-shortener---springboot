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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UrlMapping getUrlMapping() {
		return urlMapping;
	}

	public void setUrlMapping(UrlMapping urlMapping) {
		this.urlMapping = urlMapping;
	}

	public LocalDateTime getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(LocalDateTime accessTime) {
		this.accessTime = accessTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessTime, browser, country, deviceType, id, ipAddress, os, referrer, urlMapping);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlAnalytics other = (UrlAnalytics) obj;
		return Objects.equals(accessTime, other.accessTime) && Objects.equals(browser, other.browser)
				&& Objects.equals(country, other.country) && Objects.equals(deviceType, other.deviceType)
				&& Objects.equals(id, other.id) && Objects.equals(ipAddress, other.ipAddress)
				&& Objects.equals(os, other.os) && Objects.equals(referrer, other.referrer)
				&& Objects.equals(urlMapping, other.urlMapping);
	}

	@Override
	public String toString() {
		return "UrlAnalytics [id=" + id + ", urlMapping=" + urlMapping + ", accessTime=" + accessTime + ", ipAddress="
				+ ipAddress + ", browser=" + browser + ", os=" + os + ", deviceType=" + deviceType + ", country="
				+ country + ", referrer=" + referrer + "]";
	}
	
	
}
