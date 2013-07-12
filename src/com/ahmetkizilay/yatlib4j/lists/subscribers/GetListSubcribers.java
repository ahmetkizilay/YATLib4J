package com.ahmetkizilay.yatlib4j.lists.subscribers;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetListSubcribers {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/subscribers.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetListSubcribers.Response sendRequest(GetListSubcribers.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
