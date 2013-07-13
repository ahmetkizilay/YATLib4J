package com.ahmetkizilay.yatlib4j.oauthhelper;

public class OAuthRequestParams {
	private String mConsumerKey;
	private String mConsumerSecret;
	private String mOauthCallback;
	private String mXAuthAccessType;
	
	public String getConsumerKey() {
		return this.mConsumerKey;
	}
	
	public void setConsumerKey(String consumerKey) {
		this.mConsumerKey = consumerKey;
	}
	
	public String getConsumerSecret() {
		return this.mConsumerSecret;
	}
	
	public void setConsumerSecret(String consumerSecret) {
		this.mConsumerSecret = consumerSecret;
	}
	
	public String getOAuthCallback() {
		return this.mOauthCallback;
	}
	
	public void setOAuthCallback(String oAuthCallback) {
		this.mOauthCallback = oAuthCallback;
	}
	
	public String getXAuthAccessType() {
		return this.mXAuthAccessType;
	}
	
	public void setXAuthAccessType(String xAuthAccessType) {
		this.mXAuthAccessType = xAuthAccessType;
	}
}
