package com.ahmetkizilay.yatlib4j.friends;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetFriendsList {
	private static final String BASE_URL = "https://api.twitter.com/1.1/friends/list.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetFriendsList.Response sendRequest(GetFriendsList.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
