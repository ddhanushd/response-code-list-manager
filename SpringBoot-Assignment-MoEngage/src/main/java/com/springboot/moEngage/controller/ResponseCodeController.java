package com.springboot.moEngage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.moEngage.service.ResponseCodeService;

@RestController
@RequestMapping("/api/response-codes")
@CrossOrigin(origins = "http://localhost:4200")
public class ResponseCodeController {
	
	@Autowired
	private ResponseCodeService responseCodeService;

    @GetMapping
    public List<Map<String, String>> getResponseCodes(@RequestParam String filter) {
        return responseCodeService.filterResponseCodes(filter);
    }

}
