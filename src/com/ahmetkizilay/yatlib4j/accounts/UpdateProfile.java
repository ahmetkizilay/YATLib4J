package com.ahmetkizilay.yatlib4j.accounts;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class UpdateProfile {
	private static final String BASE_URL = "https://api.twitter.com/1.1/account/update_profile.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static UpdateProfile.Response sendRequest(UpdateProfile.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
