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

}
