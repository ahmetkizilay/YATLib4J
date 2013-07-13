package com.ahmetkizilay.yatlib4j.accounts;

import java.util.Hashtable;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetSettings {
	private static final String BASE_URL = "https://api.twitter.com/1.1/account/settings.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetSettings.Response sendRequest(GetSettings.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		GetSettings.Response response = new GetSettings.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static class Response {
		private String mRawResponse;
		
		public Response(String rawResponse) {
			this.mRawResponse = rawResponse;
		}
		
		public String getRawResponse() {
			return this.mRawResponse;
		}
	}
	
	public static class Parameters  {
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			return htResult;
		}
	}
}
