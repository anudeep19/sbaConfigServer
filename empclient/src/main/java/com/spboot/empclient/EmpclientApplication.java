package com.spboot.empclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class EmpclientApplication {
	
//	public String url ="http://localhost:8052/getEmployees";
	
	@Value("${emp.service.url}")
	public String url;
	
	@Autowired
	@Lazy
	RestTemplate restTemplate;
	
	public EmpclientApplication() {
		super();
	}
	
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(EmpclientApplication.class, args);
	}
	
	@GetMapping("/getEmployees")
	public List getEmployeeList() {
		return restTemplate.getForObject(url, List.class);
	}
	
}
