package com.api.rest.time.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@RestController 
@RequestMapping("/api/timestamp")
public class TimeStampController {
	private Pattern patternOne=Pattern.compile("\\d{1,13}");
	private Pattern patternTwo=Pattern.compile("\\d{4}\\-\\d{2}\\-\\d{1,2}"); 
	
	@GetMapping("/date/{date}") 
	public ResponseEntity<?> getTimeInMilliseconds(@PathVariable String date) {
		Map<String,String> response=new HashMap<String, String>();
		Matcher matchingOne=patternOne.matcher(date);
		Matcher matchingTwo=patternTwo.matcher(date);
		if (matchingOne.matches()) {
			Instant instant=Instant.ofEpochMilli(Long.parseLong(date)); 
			Date dateTime=Date.from(instant); 
			response.put("unix", date);
			response.put("utc", String.valueOf(dateTime));
			return ResponseEntity.ok(response);
		} else if (matchingTwo.matches()) {
			LocalDate localDate=LocalDate.parse(date);
			Instant instant=localDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
			Long timeStamp=instant.toEpochMilli();
			response.put("utc", date); 
			response.put("unix",String.valueOf(timeStamp));
			return ResponseEntity.ok(response);
		}
		response.put("error","Invalid date");
		return ResponseEntity.ok(response);
	}
}
