package com.ahmetkizilay.yatlib4j.statuses;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class ShowTweet {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/show.json";
	private static final String HTTP_METHOD = "GET";
	
	public static ShowTweet.Response sendRequest(ShowTweet.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
