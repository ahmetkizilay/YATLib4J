package com.ahmetkizilay.yatlib4j.users;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class ShowUser {
	private static final String BASE_URL = "https://api.twitter.com/1.1/users/show.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static ShowUser.Response sendRequest(ShowUser.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
