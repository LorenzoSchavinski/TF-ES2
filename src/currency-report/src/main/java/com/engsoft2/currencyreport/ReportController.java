package com.engsoft2.currencyreport;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

	// Mock exchange rates
	private static final Map<String, Double> MOCK_RATES = new HashMap<>();

	static {
		MOCK_RATES.put("USD_BRL", 5.42);
		MOCK_RATES.put("USD_EUR", 0.92);
		MOCK_RATES.put("BRL_EUR", 0.17);
		MOCK_RATES.put("EUR_BRL", 5.88);
		MOCK_RATES.put("EUR_USD", 1.09);
		MOCK_RATES.put("BRL_USD", 0.18);
	}

	@GetMapping("/health")
	public HealthResponse health() {
		return new HealthResponse("UP");
	}

	@GetMapping("/quote")
	public Quote getQuote(@RequestParam String from, @RequestParam String to) {
		String key = from + "_" + to;
		double rate = MOCK_RATES.getOrDefault(key, 1.0);
		return new Quote(from, to, rate);
	}

}
