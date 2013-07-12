package com.ahmetkizilay.yatlib4j.statuses;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetOEmbed {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/oembed.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetOEmbed.Response sendRequest(GetOEmbed.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
