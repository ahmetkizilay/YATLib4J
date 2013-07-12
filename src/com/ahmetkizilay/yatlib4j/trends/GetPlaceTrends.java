package com.ahmetkizilay.yatlib4j.trends;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetPlaceTrends {
	private static final String BASE_URL = "https://api.twitter.com/1.1/trends/place.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetPlaceTrends.Response sendRequest(GetPlaceTrends.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
