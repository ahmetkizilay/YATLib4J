package com.ahmetkizilay.yatlib4j.datatypes;

public class RateLimitStatus {
	private int remaining;
	private int reset;
	private int limit;
	
	public int getRemaining() {
		return this.remaining;
	}
	
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	
	public int getReset() {
		return this.reset;
	}
	
	public void setReset(int reset) {
		this.reset = reset;
	}
	
	public int getLimit() {
		return this.limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
