package com.dtcc.pot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import brave.sampler.Sampler;

@SpringBootApplication
public class SpringCloudZipkinAppTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinAppTwoApplication.class, args);
	}
	
//	@Bean
//	public WebClient.Builder getWebClientBuilder() {
//
//		return WebClient.builder();
//
//	}
	@Bean
	public WebClient getWebClientBuilder() {

		return WebClient.builder().build();

	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Sampler alwaysSampler() {

		return Sampler.ALWAYS_SAMPLE;
	}

}
