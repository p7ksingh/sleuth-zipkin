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
	private RestTemplate restTmplate;

	@GetMapping("/msone")
	public String RestapplicationOne() {

		log.info("welcome To Application One");
		String response = restTmplate.getForObject("http://localhost:8082/mstwo", String.class);

		log.info("Back To Application One , Data is {}", response);
		return "Success";
	}

	// byUsing Webclient

	@GetMapping("/ms-one")
	public String webClientApplicationOne() {

		String responce = webClient.get().uri("http://localhost:8082/ms-two").retrieve().bodyToMono(String.class)
				.block();

		return responce;

	}

}