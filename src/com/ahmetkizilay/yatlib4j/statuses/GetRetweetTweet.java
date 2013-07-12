package com.ahmetkizilay.yatlib4j.statuses;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetRetweetTweet {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/retweet/:id.json";
	private static final String HTTP_METHOD = "POST";
	
	public static GetRetweetTweet.Response sendRequest(GetRetweetTweet.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
