package com.ahmetkizilay.yatlib4j.lists;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class CreateList {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/create.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static CreateList.Response sendRequest(CreateList.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
