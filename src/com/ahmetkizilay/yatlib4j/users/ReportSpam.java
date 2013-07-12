package com.ahmetkizilay.yatlib4j.users;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class ReportSpam {
	private static final String BASE_URL = "https://api.twitter.com/1.1/users/report_spam.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static ReportSpam.Response sendRequest(ReportSpam.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
