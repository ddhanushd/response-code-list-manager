package com.springboot.moEngage.service;

import java.util.List;
import java.util.Map;

public interface ResponseCodeService {
	
	 public List<Map<String, String>> filterResponseCodes(String filter);

}
