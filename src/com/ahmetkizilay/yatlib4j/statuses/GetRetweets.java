package com.ahmetkizilay.yatlib4j.statuses;


import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetRetweets {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/retweets/:id.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetRetweets.Response sendRequest(GetRetweets.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
