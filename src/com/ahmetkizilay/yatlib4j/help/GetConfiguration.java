package com.ahmetkizilay.yatlib4j.help;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetConfiguration {
	private static final String BASE_URL = "https://api.twitter.com/1.1/help/configuration.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetConfiguration.Response sendRequest(GetConfiguration.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
