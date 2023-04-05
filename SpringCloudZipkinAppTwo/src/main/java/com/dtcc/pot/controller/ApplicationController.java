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
	private WebClient webClient;
	@Autowired
	public RestTemplate restTmplate;

	@GetMapping("/mstwo")
	public String restApplicationTwo() {

		log.info("welcome To Application Two");
		String response = restTmplate.getForObject("http://localhost:8083/msthree", String.class);
		log.info("Back To Application TWO , Data is {}", response);
		return "Success responce from Rest-MStwo =>" + response;
	}

	// byUsing Webclient

	@GetMapping("/ms-two")
	public String webClientApplicationTwo() {

		String response = webClient.get().uri("http://localhost:8083/ms-three").retrieve().bodyToMono(String.class)
				.block();

		return "Success responce from webclient-MStwo =>" + response;

	}
}
