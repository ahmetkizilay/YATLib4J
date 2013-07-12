package com.ahmetkizilay.yatlib4j.accounts;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class UpdateProfileColors {
	private static final String BASE_URL = "https://api.twitter.com/1.1/account/update_profile_colors.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static UpdateProfileColors.Response sendRequest(UpdateProfileColors.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
