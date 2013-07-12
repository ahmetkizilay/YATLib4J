package com.ahmetkizilay.yatlib4j.geo;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class SearchPlaces {
	private static final String BASE_URL = "https://api.twitter.com/1.1/geo/similar_places.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static SearchPlaces.Response sendRequest(SearchPlaces.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
