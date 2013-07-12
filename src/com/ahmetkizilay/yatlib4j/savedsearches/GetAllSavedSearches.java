package com.ahmetkizilay.yatlib4j.savedsearches;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetAllSavedSearches {
	private static final String BASE_URL = "https://api.twitter.com/1.1/saved_searches/list.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetAllSavedSearches.Response sendRequest(GetAllSavedSearches.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
