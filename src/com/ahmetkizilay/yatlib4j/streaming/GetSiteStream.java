package com.ahmetkizilay.yatlib4j.streaming;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetSiteStream {
	private static final String BASE_URL = "https://sitestream.twitter.com/1.1/site.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetSiteStream.Response sendRequest(GetSiteStream.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
