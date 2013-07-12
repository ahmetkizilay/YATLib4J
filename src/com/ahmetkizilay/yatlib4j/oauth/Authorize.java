package com.ahmetkizilay.yatlib4j.oauth;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class Authorize {
	private static final String BASE_URL = "https://api.twitter.com/1.1/oauth/authorize";
	private static final String HTTP_METHOD = "POST"; 
	
	public static Authorize.Response sendRequest(Authorize.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
