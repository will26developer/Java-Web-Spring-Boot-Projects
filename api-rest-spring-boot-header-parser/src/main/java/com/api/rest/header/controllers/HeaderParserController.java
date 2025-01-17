package com.api.rest.header.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class HeaderParserController {
	
	@GetMapping("/whoami/{whoami}")
	public ResponseEntity<?> getHeaders(@PathVariable String whoami,
			                            @RequestHeader(value = "X-Forwarded-For",required = false,defaultValue = "unknow") String ipAdress, 
			                            @RequestHeader(value = "Accept-Language",required = false,defaultValue = "unknow") String language,
			                            @RequestHeader(value = "User-Agent",required = false,defaultValue = "unknow") String userAgent,
			                            HttpServletRequest request) {
		Map<String, String> response=new HashMap<String, String>();
		if (whoami.equals("whoami")) {
			response.put("ipadress",ipAdress);
			response.put("language", language); 
			response.put("software", userAgent); 
			return ResponseEntity.ok(response);
		} 
		return ResponseEntity.badRequest().build();
	}
}
