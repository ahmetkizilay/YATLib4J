package com.ahmetkizilay.yatlib4j.friendships;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class DestroyFriendship {
	private static final String BASE_URL = "https://api.twitter.com/1.1/friendships/destroy.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static DestroyFriendship.Response sendRequest(DestroyFriendship.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
