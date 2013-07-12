package com.ahmetkizilay.yatlib4j.dm;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class DeleteDirectMessage {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages/destroy.json";
	private static final String HTTP_METHOD = "POST";
	
	public static DeleteDirectMessage.Response sendRequest(DeleteDirectMessage.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
