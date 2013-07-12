package com.ahmetkizilay.yatlib4j.lists.members;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class RemoveListMembers {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/members/destroy.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static RemoveListMembers.Response sendRequest(RemoveListMembers.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
