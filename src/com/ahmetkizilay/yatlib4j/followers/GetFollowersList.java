package com.ahmetkizilay.yatlib4j.followers;

import java.util.Hashtable;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetFollowersList {
	private static final String BASE_URL = "https://api.twitter.com/1.1/followers/list.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetFollowersList.Response sendRequest(GetFollowersList.Parameters params, OAuthHolder oauthHolder) {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		GetFollowersList.Response response = new GetFollowersList.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static class Response {
		public Response(String responseString) {			
		}
	}
	
	public static class Parameters  {		
		public Hashtable<String, String> prepareParams() {
			return null;
		}
	}
}
