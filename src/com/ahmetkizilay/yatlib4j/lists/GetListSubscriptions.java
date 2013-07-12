package com.ahmetkizilay.yatlib4j.lists;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetListSubscriptions {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/subscriptions.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetListSubscriptions.Response sendRequest(GetListSubscriptions.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
