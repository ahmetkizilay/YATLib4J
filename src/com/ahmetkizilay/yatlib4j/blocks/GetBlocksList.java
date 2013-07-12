package com.ahmetkizilay.yatlib4j.blocks;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetBlocksList {
	private static final String BASE_URL = "https://api.twitter.com/1.1/blocks/list.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetBlocksList.Response sendRequest(GetBlocksList.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
