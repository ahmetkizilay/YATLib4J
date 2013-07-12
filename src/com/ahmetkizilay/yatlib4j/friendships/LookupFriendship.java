package com.ahmetkizilay.yatlib4j.friendships;

import com.ahmetkizilay.yatlib4j.friends.GetFriendIds;
import com.ahmetkizilay.yatlib4j.friends.GetFriendIds.Parameters;
import com.ahmetkizilay.yatlib4j.friends.GetFriendIds.Response;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class LookupFriendship {
	private static final String BASE_URL = "https://api.twitter.com/1.1/friendships/lookup.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetFriendIds.Response sendRequest(GetFriendIds.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
