package com.ahmetkizilay.yatlib4j.oauth;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetAccessToken {
	private static final String BASE_URL = "https://api.twitter.com/oauth/access_token";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetAccessToken.Response sendRequest(GetAccessToken.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
