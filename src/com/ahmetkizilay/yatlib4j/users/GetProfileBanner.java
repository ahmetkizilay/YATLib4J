package com.ahmetkizilay.yatlib4j.users;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetProfileBanner {
	private static final String BASE_URL = "https://api.twitter.com/1.1/users/profile_banner.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetProfileBanner.Response sendRequest(GetProfileBanner.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
