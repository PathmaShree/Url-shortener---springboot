package com.example.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.url.entity.UrlMapping;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UrlMappingRepository  extends JpaRepository<UrlMapping,Long>{
          Optional<UrlMapping> findByShortCode(String shortCode);
          void  deleteByExpireAtBefore(LocalDateTime now);

}
