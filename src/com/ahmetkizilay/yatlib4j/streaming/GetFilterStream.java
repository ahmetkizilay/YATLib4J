package com.ahmetkizilay.yatlib4j.streaming;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetFilterStream {
	private static final String BASE_URL = "https://stream.twitter.com/1.1/statuses/filter.json";
	private static final String HTTP_METHOD = "POST";
	
	public static GetFilterStream.Response sendRequest(GetFilterStream.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
