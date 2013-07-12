package com.ahmetkizilay.yatlib4j.oauthhelper;

public class AppAuthHolder {
	private String tokenType;
	private String accessToken;
	
	public String getTokenType() {
		return this.tokenType;
	}
	
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	public String getAccessToken() {
		return this.accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
