package com.ahmetkizilay.yatlib4j.dm;

import java.util.Hashtable;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.datatypes.Tweet;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class ShowDirectMessage {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages/show.json";
	private static final String HTTP_METHOD = "GET";
	
	public static ShowDirectMessage.Response sendRequest(ShowDirectMessage.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		ShowDirectMessage.Response response = new ShowDirectMessage.Response(twitterResponse.getResponse());		
		return response;
	}	
	
	public static class Response {
		private String mRawResponse;
		
		public Response(String rawResponse) {
			this.mRawResponse = rawResponse;
		}
		
		public Tweet getTweet() {
			JSONObject jsonObject = (JSONObject) JSONValue.parse(this.mRawResponse);
			return Tweet.fromJSON(jsonObject);
		}
	}
	
	public static class Parameters  {
		private String id;
		
		public String getId() {
			return id;
		}
		
		/***
		 * The ID of the direct message.
		 * 
		 * @param id
		 */
		public void setId(String id) {
			this.id = id;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			
			if(this.id != null && !this.id.equals("")) {
				htResult.put("id", this.id);
			}
			
			return htResult;
		}
		
		
	}
}
