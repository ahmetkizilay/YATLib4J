package com.ahmetkizilay.yatlib4j.users.suggestions;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetSuggestedUsers {
	private static final String BASE_URL = "https://api.twitter.com/1.1/users/suggestions/:slug.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetSuggestedUsers.Response sendRequest(GetSuggestedUsers.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
