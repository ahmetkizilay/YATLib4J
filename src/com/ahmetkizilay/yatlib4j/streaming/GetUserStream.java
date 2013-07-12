package com.ahmetkizilay.yatlib4j.streaming;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetUserStream {
	private static final String BASE_URL = "https://userstream.twitter.com/1.1/user.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetUserStream.Response sendRequest(GetUserStream.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
