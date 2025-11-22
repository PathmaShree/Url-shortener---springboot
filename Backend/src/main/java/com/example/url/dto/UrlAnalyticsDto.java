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
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDateTime getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(LocalDateTime accessTime) {
		this.accessTime = accessTime;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
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
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accessTime, browser, deviceType, ipAdress, os, referrer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlAnalyticsDto other = (UrlAnalyticsDto) obj;
		return Objects.equals(accessTime, other.accessTime) && Objects.equals(browser, other.browser)
				&& Objects.equals(deviceType, other.deviceType) && Objects.equals(ipAdress, other.ipAdress)
				&& Objects.equals(os, other.os) && Objects.equals(referrer, other.referrer);
	}
	@Override
	public String toString() {
		return "UrlAnalyticsDto [accessTime=" + accessTime + ", ipAdress=" + ipAdress + ", browser=" + browser + ", os="
				+ os + ", deviceType=" + deviceType + ", referrer=" + referrer + "]";
	}
	
	
	
}
