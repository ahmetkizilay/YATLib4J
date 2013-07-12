package com.ahmetkizilay.yatlib4j.oauth2;

import java.util.Hashtable;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.AppAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetToken {
	private static final String BASE_URL = "https://api.twitter.com/oauth2/token";
	private static final String HTTP_METHOD = "POST"; 
	
	public static GetToken.Response sendRequest(String consumerKey, String consumerSecret) throws TwitterIOException {
		GetToken.Parameters params = new GetToken.Parameters();
		params.setGrantType("client_credentials");
		
		Hashtable<String, String> httpParams = params.prepareParams();
		String authHeader = OAuthUtils.generateAppOnlyAuthHeader(consumerKey, consumerSecret);

		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequestAppAuth(HTTP_METHOD, BASE_URL, httpParams, authHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		return new Response(twitterResponse.getResponse());
	}	
	
	public static class Response {
		private String rawResponse;
		
		public Response(String rawResponse) {
			this.rawResponse = rawResponse;
		}
		
		public String getTokenType() {
			JSONObject jsonObject = (JSONObject) JSONValue.parse(this.rawResponse);
			return (String) jsonObject.get("token_type");
		}
		
		public String getAccessToken() {
			JSONObject jsonObject = (JSONObject) JSONValue.parse(this.rawResponse);
			return (String) jsonObject.get("access_token");
		}
		
		public AppAuthHolder getAppAuthHolder() {
			JSONObject jsonObject = (JSONObject) JSONValue.parse(this.rawResponse);
			AppAuthHolder holder = new AppAuthHolder();
			holder.setAccessToken( (String) jsonObject.get("access_token"));
			holder.setTokenType( (String) jsonObject.get("token_type"));
			return holder;
		}
	}
	
	public static class Parameters  {
		private String grantType;
		
		public String getGrantType() {
			return this.grantType;
		}
		
		/***
		 * Specifies the type of grant being requested by the application. At this time, only client_credentials is allowed.
		 * See Application-only authentication for more information.
		 * 
		 * @param grantType
		 */
		public void setGrantType(String grantType) {
			this.grantType = grantType;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
					
			if(this.grantType != null && !this.grantType.equals("")) {
				htResult.put("grant_type", this.grantType);
			}
						
			return htResult;
		}
		
		
	}
}
