package com.ahmetkizilay.yatlib4j.users.suggestions;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetSuggestionCategories {
	private static final String BASE_URL = "https://api.twitter.com/1.1/users/suggestions.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetSuggestionCategories.Response sendRequest(GetSuggestionCategories.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
