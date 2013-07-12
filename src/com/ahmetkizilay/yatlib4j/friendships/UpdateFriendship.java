package com.ahmetkizilay.yatlib4j.friendships;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class UpdateFriendship {
	private static final String BASE_URL = "https://api.twitter.com/1.1/friendships/update.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static UpdateFriendship.Response sendRequest(UpdateFriendship.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
