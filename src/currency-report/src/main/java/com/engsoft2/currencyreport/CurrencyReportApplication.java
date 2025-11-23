package com.engsoft2.currencyreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyReportApplication.class, args);
	}

}
