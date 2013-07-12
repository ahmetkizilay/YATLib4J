package com.ahmetkizilay.yatlib4j.dm;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetSentMessages {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages/sent.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetSentMessages.Response sendRequest(GetSentMessages.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
