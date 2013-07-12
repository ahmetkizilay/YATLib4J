package com.ahmetkizilay.yatlib4j.oauth2;

import java.util.Hashtable;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class InvalidateToken {
	private static final String BASE_URL = "https://api.twitter.com/oauth2/invalidate_token";
    private static final String HTTP_METHOD = "POST"; 
	
	public static InvalidateToken.Response sendRequest(String accessToken, String consumerKey, String consumerSecret) throws TwitterIOException {
		InvalidateToken.Parameters params = new InvalidateToken.Parameters();
		params.setAccessToken(accessToken);
		Hashtable<String, String> httpParams = params.prepareParams();
		
		String authHeader = OAuthUtils.generateAppOnlyAuthHeader(consumerKey, consumerSecret);
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequestAppAuth(HTTP_METHOD, BASE_URL, httpParams, authHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		InvalidateToken.Response response = new InvalidateToken.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static class Response {
		private String rawResponse;
		
		public Response(String rawResponse) {
			this.rawResponse = rawResponse;
		}
		
		public String getAccessToken() {
			JSONObject jsonObj = (JSONObject) JSONValue.parse(this.rawResponse);
			return (String) jsonObj.get("access_token");
		}
	}
	
	public static class Parameters  {
		private String accessToken;
		
		public String getAccessToken() {
			return this.accessToken;
		}
		
		/***
		 * The value of the bearer token to revoke.
		 * 
		 * @param accessToken
		 */
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
					
			if(this.accessToken != null && !this.accessToken.equals("")) {
				htResult.put("access_token", this.accessToken);
			}
						
			return htResult;
		}
	}
}
