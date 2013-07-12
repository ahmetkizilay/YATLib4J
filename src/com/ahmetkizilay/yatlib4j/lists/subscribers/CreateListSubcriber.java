package com.ahmetkizilay.yatlib4j.lists.subscribers;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class CreateListSubcriber {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/subscribers/create.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static CreateListSubcriber.Response sendRequest(CreateListSubcriber.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
