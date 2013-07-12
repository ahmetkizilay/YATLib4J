package com.ahmetkizilay.yatlib4j.favorites;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class DeleteFavorite {
	private static final String BASE_URL = "https://api.twitter.com/1.1/favorites/destroy.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static DeleteFavorite.Response sendRequest(DeleteFavorite.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}	
}
