package com.ahmetkizilay.yatlib4j.blocks;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class CreateBlock {
	private static final String BASE_URL = "https://api.twitter.com/1.1/blocks/create.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static CreateBlock.Response sendRequest(CreateBlock.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
