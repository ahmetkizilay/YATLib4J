package com.ahmetkizilay.yatlib4j.accounts;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetSettings {
	private static final String BASE_URL = "https://api.twitter.com/1.1/account/settings.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetSettings.Response sendRequest(GetSettings.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
