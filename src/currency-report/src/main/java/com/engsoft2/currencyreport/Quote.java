package com.engsoft2.currencyreport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Quote {
	private String from;
	private String to;
	private double price;
	private String timestamp;

	public Quote(String from, String to, double price) {
		this.from = from;
		this.to = to;
		this.price = price;
		this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
