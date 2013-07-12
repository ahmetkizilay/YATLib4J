package com.ahmetkizilay.yatlib4j.friendships;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class CreateFriendship {
	private static final String BASE_URL = "https://api.twitter.com/1.1/friendships/create.json";
	private static final String HTTP_METHOD = "POST";
	
	public static CreateFriendship.Response sendRequest(CreateFriendship.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
