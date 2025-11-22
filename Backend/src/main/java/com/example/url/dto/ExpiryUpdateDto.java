package com.example.url.dto;

import java.util.Objects;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class ExpiryUpdateDto {

	@Min(value = 1, message = "Minimum expiry is 1 hour")
    @Max(value = 24 * 365, message = "Maximum expiry is 1 year (hours)")
    private Integer expiryHours;

	public Integer getExpiryHours() {
		return expiryHours;
	}

	public void setExpiryHours(Integer expiryHours) {
		this.expiryHours = expiryHours;
	}

	@Override
	public int hashCode() {
		return Objects.hash(expiryHours);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpiryUpdateDto other = (ExpiryUpdateDto) obj;
		return Objects.equals(expiryHours, other.expiryHours);
	}

	@Override
	public String toString() {
		return "ExpiryUpdateDto [expiryHours=" + expiryHours + "]";
	}
	
	
}
