package com.ahmetkizilay.yatlib4j.geo;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetPlaceInfo {
	private static final String BASE_URL = "https://api.twitter.com/1.1/geo/reverse_geocode.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetPlaceInfo.Response sendRequest(GetPlaceInfo.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
