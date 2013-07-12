package com.ahmetkizilay.yatlib4j.lists;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class DeleteList {
	private static final String BASE_URL = "https://api.twitter.com/1.1/lists/destroy.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static DeleteList.Response sendRequest(DeleteList.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
