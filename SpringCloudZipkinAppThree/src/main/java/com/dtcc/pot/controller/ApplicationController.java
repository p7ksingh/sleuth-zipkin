package com.dtcc.pot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ApplicationController {

	@Autowired
	public RestTemplate restTmplate;
	
	@Autowired
	private WebClient webClient;

	@GetMapping("/msthree")
	public String applicationOne() {

		log.info("welcome To Application Three");

		log.info("Bye From Application Three");
		return "Success form Rest-MSThree";
	}
	
	@GetMapping("/ms-three")
	public String applicationThree() {

		log.info("welcome To Application Three");

		log.info("Bye From Application Three");
		return "Success form webclient-MSThree";
	}
}
