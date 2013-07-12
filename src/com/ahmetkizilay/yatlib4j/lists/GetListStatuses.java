package com.ahmetkizilay.yatlib4j.lists;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetListStatuses {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/statuses.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetListStatuses.Response sendRequest(GetListStatuses.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
