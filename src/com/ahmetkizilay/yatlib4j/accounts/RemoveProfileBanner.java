package com.ahmetkizilay.yatlib4j.accounts;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class RemoveProfileBanner {
	private static final String BASE_URL = "https://api.twitter.com/1.1/account/remove_profile_banner.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static RemoveProfileBanner.Response sendRequest(RemoveProfileBanner.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
