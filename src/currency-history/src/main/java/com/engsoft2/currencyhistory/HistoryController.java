package com.engsoft2.currencyhistory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

	@GetMapping("/health")
	public HealthResponse health() {
		return new HealthResponse("UP");
	}

	@GetMapping("/history")
	public History getHistory(@RequestParam String from, @RequestParam String to) {
		// Generate mock history with timestamps
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

		List<HistoryValue> values = new ArrayList<>();
		values.add(new HistoryValue(now.minusHours(2).format(formatter), 5.35));
		values.add(new HistoryValue(now.minusHours(1).format(formatter), 5.38));
		values.add(new HistoryValue(now.format(formatter), 5.42));

		return new History(from, to, values);
	}

}
