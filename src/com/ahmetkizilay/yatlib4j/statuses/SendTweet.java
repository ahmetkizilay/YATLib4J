package com.ahmetkizilay.yatlib4j.statuses;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class SendTweet {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/update.json";
	private static final String HTTP_METHOD = "POST";
	
	public static SendTweet.Response sendRequest(SendTweet.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
