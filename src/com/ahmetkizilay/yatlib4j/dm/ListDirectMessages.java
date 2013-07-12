package com.ahmetkizilay.yatlib4j.dm;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class ListDirectMessages {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages.json";
	private static final String HTTP_METHOD = "GET";
	
	public static ListDirectMessages.Response sendRequest(ListDirectMessages.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
