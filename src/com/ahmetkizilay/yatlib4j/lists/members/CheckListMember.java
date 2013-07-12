package com.ahmetkizilay.yatlib4j.lists.members;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class CheckListMember {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/members/show.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static CheckListMember.Response sendRequest(CheckListMember.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
