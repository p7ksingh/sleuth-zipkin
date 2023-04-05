package com.dtcc.pot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import brave.sampler.Sampler;

@SpringBootApplication
public class SpringCloudZipkinAppThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinAppThreeApplication.class, args);
	}
	@Bean
	public WebClient webClient() {

		return WebClient.builder().build();
	}

	@Bean
	public Sampler alwaysSampler() {

		return Sampler.ALWAYS_SAMPLE;
	}

//	@Bean
//	public WebClient.Builder getWebClientBuilder() {
//
//		return WebClient.builder();
//
//	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
