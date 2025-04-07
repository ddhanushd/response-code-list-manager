package com.springboot.moEngage.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.moEngage.entities.ResponseCodes;
import com.springboot.moEngage.repository.ResponseCodeRepository;

@Service
public class ResponseCodeServiceImpl implements ResponseCodeService {
	
	@Autowired
	private ResponseCodeRepository responseCodeRepository;

	@Override
	public List<Map<String, String>> filterResponseCodes(String filter) {
		List<ResponseCodes> responseCodes;

        if (filter.matches("\\d{3}")) { 
            responseCodes = responseCodeRepository.findById(filter).stream().toList();
        } else if (filter.matches("\\dxx")) { 
            responseCodes = responseCodeRepository.findByCodeStartingWith(filter.substring(0, 1));
        } else if (filter.matches("\\d{2}x")) { 
            responseCodes = responseCodeRepository.findByCodeStartingWith(filter.substring(0, 2));
        } else {
            return Collections.emptyList(); 
        }

        return responseCodes.stream()
            .map(rc -> Map.of("responseCode", rc.getCode(), "imageUrl", rc.getImageUrl()))
            .collect(Collectors.toList());
    }
	

}
