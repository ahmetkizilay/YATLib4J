package com.ahmetkizilay.yatlib4j.geo;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetReverseGeocode {
	private static final String BASE_URL = "https://api.twitter.com/1.1/geo/id/:place_id.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetReverseGeocode.Response sendRequest(GetReverseGeocode.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
