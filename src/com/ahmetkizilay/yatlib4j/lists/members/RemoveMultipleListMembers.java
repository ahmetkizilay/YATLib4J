package com.ahmetkizilay.yatlib4j.lists.members;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class RemoveMultipleListMembers {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/members/destroy_all.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static RemoveMultipleListMembers.Response sendRequest(RemoveMultipleListMembers.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
