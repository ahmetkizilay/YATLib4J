package com.ahmetkizilay.yatlib4j.geo;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class CreatePlace {
	private static final String BASE_URL = "https://api.twitter.com/1.1/geo/place.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static CreatePlace.Response sendRequest(CreatePlace.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
