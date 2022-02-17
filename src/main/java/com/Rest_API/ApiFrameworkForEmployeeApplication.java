package com.Rest_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ApiFrameworkForEmployeeApplication
{

	public static void main(String[] args)
	{
		System.setProperty("server.port", "8090");
		SpringApplication.run(ApiFrameworkForEmployeeApplication.class, args);
	}

}
