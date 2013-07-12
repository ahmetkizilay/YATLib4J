package com.ahmetkizilay.yatlib4j.blocks;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetBlocksIds {
	private static final String BASE_URL = "https://api.twitter.com/1.1/blocks/ids.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetBlocksIds.Response sendRequest(GetBlocksIds.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
