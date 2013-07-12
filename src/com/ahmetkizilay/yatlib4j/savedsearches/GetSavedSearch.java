package com.ahmetkizilay.yatlib4j.savedsearches;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetSavedSearch {
	private static final String BASE_URL = "https://api.twitter.com/1.1/saved_searches/show/:id.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetSavedSearch.Response sendRequest(GetSavedSearch.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
