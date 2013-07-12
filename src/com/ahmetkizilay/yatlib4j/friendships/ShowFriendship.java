package com.ahmetkizilay.yatlib4j.friendships;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class ShowFriendship {
	private static final String BASE_URL = "https://api.twitter.com/1.1/friendships/show.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static ShowFriendship.Response sendRequest(ShowFriendship.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
