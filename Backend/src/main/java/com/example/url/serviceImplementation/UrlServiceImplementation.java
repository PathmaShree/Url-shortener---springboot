package com.example.url.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.url.dto.ExpiryUpdateDto;
import com.example.url.dto.UrlAnalyticsDto;
import com.example.url.dto.UrlRequestDto;
import com.example.url.dto.UrlResponseDto;
import com.example.url.entity.UrlAnalytics;
import com.example.url.entity.UrlMapping;
import com.example.url.mapper.UrlAnalyticsMapper;
import com.example.url.mapper.UrlMapper;
import com.example.url.repository.UrlAnalyticsRepository;
import com.example.url.repository.UrlMappingRepository;
import com.example.url.service.UrlService;
import com.example.url.util.Base62Encoder;
import com.example.url.util.UserAgent;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UrlServiceImplementation implements UrlService{

	private final UrlMappingRepository urlRepo;
	private final UrlAnalyticsRepository urlAnalyticsRepo;
	
	public UrlServiceImplementation(UrlMappingRepository urlRepo,UrlAnalyticsRepository urlAnalyticsRepo) {
		this.urlRepo = urlRepo;
		this.urlAnalyticsRepo = urlAnalyticsRepo;
	}

	@Override
	public UrlResponseDto createShortUrl(UrlRequestDto dto) {
//		// TODO Auto-generated method stub
		UrlMapping url = UrlMapper.toEntity(dto);
		UrlMapping saved = urlRepo.save(url);
		String shortCode = Base62Encoder.encode(saved.getId());
		saved.setShortCode(shortCode);
		LocalDateTime expireAt = LocalDateTime.now().plusHours(dto.getExpiryHours());
		url.setExpireAt(expireAt);
		urlRepo.save(saved);
		return UrlMapper.toDto(saved);
	}

	@Override
	public String getOriginalUrl(String shortCode, HttpServletRequest request) {
		// TODO Auto-generated method stub
		UrlMapping url = urlRepo.findByShortCode(shortCode)
				.orElseThrow(()->new RuntimeException("URL not found"));
		if(url.getExpireAt()!=null && url.getExpireAt().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("URL expired");
		}
		UrlAnalytics log = new UrlAnalytics();
		log.setUrlMapping(url);
		log.setAccessTime(LocalDateTime.now());
		log.setIpAddress(request.getRemoteAddr());
		log.setBrowser(UserAgent.getBrowser(request));
		log.setOs(UserAgent.getOs(request));
		log.setDeviceType(UserAgent.getDeviceType(request));
		log.setReferrer(request.getHeader("Referrer"));
		urlAnalyticsRepo.save(log); 

		return url.getOriginalUrl();
	}

	@Override
	public List<UrlAnalyticsDto> getAnalytics(String shortCode) {
		// TODO Auto-generated method stub
		UrlMapping url = urlRepo.findByShortCode(shortCode)
				.orElseThrow(() -> new RuntimeException("URL not found"));
		List<UrlAnalytics> log = urlAnalyticsRepo.findByUrlMapping(url);
		return UrlAnalyticsMapper.toDtoList(log);
	}

	@Override
	public UrlResponseDto getById(Long id) {
		// TODO Auto-generated method stub
		UrlMapping url = urlRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("URL not found"));
		return UrlMapper.toDto(url);
	}

	@Override
	public List<UrlResponseDto> getAllUrls() {
		// TODO Auto-generated method stub
		return urlRepo.findAll()
				.stream()
				.map(UrlMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public UrlResponseDto update(Long id, ExpiryUpdateDto dto) {
		// TODO Auto-generated method stub
		UrlMapping url = urlRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("URL not found"));
		url.setExpireAt(LocalDateTime.now().plusHours(dto.getExpiryHours()));
		UrlMapping saved = urlRepo.save(url);
		return UrlMapper.toDto(saved);
	}

	@Override
	public void deleteUrl(Long id) {
		// TODO Auto-generated method stub
		if(!urlRepo.existsById(id)) throw new RuntimeException("URL not found");
		urlRepo.deleteById(id);
		
	}
	
}
