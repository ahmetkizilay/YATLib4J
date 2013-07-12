package com.ahmetkizilay.yatlib4j.search;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class SearchTweets {
	private static final String BASE_URL = "https://api.twitter.com/1.1/search/tweets.json";
	private static final String HTTP_METHOD = "GET";
	
	public static SearchTweets.Response sendRequest(SearchTweets.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
