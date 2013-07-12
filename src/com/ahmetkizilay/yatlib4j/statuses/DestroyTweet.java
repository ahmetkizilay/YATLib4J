package com.ahmetkizilay.yatlib4j.statuses;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class DestroyTweet {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/destroy/:id.json";
	private static final String HTTP_METHOD = "POST";
	
	public static DestroyTweet.Response sendRequest(DestroyTweet.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
