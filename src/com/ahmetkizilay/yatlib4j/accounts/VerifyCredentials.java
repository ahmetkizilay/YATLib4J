package com.ahmetkizilay.yatlib4j.accounts;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class VerifyCredentials {
	private static final String BASE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static VerifyCredentials.Response sendRequest(VerifyCredentials.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
