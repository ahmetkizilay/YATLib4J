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

public class DeleteDirectMessage {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages/destroy.json";
	private static final String HTTP_METHOD = "POST";
	
	public static DeleteDirectMessage.Response sendRequest(DeleteDirectMessage.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		DeleteDirectMessage.Response response = new DeleteDirectMessage.Response(twitterResponse.getResponse());		
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
		private String includeEntities;
		
		public String getId() {
			return id;
		}
		
		/***
		 * The ID of the direct message to delete.
		 * 
		 * @param id
		 */
		public void setId(String id) {
			this.id = id;
		}
		
		public String getIncludeEntities() {
			return includeEntities;
		}
		
		/***
		 * The entities node will not be included when set to false.
		 * 
		 * @param includeEntities
		 */
		public void setIncludeEntities(String includeEntities) {
			this.includeEntities = includeEntities;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			
			if(this.id != null && !this.id.equals("")) {
				htResult.put("id", this.id);
			}
			if(this.includeEntities != null && !this.includeEntities.equals("")) {
				htResult.put("include_entities", this.includeEntities);
			}
			
			return htResult;
		}
		
		
	}
}
