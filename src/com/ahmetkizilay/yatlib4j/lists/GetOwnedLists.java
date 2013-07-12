package com.ahmetkizilay.yatlib4j.lists;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetOwnedLists {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/ownerships.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetOwnedLists.Response sendRequest(GetOwnedLists.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
