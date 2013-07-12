package com.ahmetkizilay.yatlib4j.oauthhelper;

public class OAuthHolder {
	private String consumerKey;
	private String consumerSecret;
	private String oauthToken;
	private String oauthTokenSecret;
	
	public OAuthHolder() {
		
	}
	
	public String getConsumerKey() {
		return this.consumerKey;
	}
	
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}
	
	public String getConsumerSecret() {
		return this.consumerSecret;
	}
	
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}
	
	public String getOAuthToken() {
		return this.oauthToken;
	}
	
	public void setOAuthToken(String oauthToken) {
		this.oauthToken = oauthToken;
	}
	
	public String getOAuthTokenSecret() {
		return this.oauthTokenSecret;
	}
	
	public void setOAuthTokenSecret(String oauthTokenSecret) {
		this.oauthTokenSecret = oauthTokenSecret;
	}
	
}
