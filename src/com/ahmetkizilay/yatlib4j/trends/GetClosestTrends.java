package com.ahmetkizilay.yatlib4j.trends;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetClosestTrends {
	private static final String BASE_URL = "https://api.twitter.com/1.1/trends/closest.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetClosestTrends.Response sendRequest(GetClosestTrends.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
