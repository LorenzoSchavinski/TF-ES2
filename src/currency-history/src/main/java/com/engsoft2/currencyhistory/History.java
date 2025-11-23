package com.engsoft2.currencyhistory;

import java.util.List;

public class History {
	private String from;
	private String to;
	private List<HistoryValue> values;

	public History(String from, String to, List<HistoryValue> values) {
		this.from = from;
		this.to = to;
		this.values = values;
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

	public List<HistoryValue> getValues() {
		return values;
	}

	public void setValues(List<HistoryValue> values) {
		this.values = values;
	}

}
