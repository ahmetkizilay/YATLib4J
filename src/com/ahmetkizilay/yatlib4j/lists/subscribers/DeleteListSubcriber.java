package com.ahmetkizilay.yatlib4j.lists.subscribers;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class DeleteListSubcriber {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/subscribers/destroy.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static DeleteListSubcriber.Response sendRequest(DeleteListSubcriber.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
