package com.ahmetkizilay.yatlib4j.friends;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetFriendIds {
	private static final String BASE_URL = "https://api.twitter.com/1.1/friends/ids.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetFriendIds.Response sendRequest(GetFriendIds.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
