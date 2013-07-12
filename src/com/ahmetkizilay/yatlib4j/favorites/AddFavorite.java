package com.ahmetkizilay.yatlib4j.favorites;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class AddFavorite {
	private static final String BASE_URL = "https://api.twitter.com/1.1/favorites/create.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static AddFavorite.Response sendRequest(AddFavorite.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}	
}
