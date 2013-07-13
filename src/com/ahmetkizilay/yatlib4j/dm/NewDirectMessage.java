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

public class NewDirectMessage {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages/new.json";
	private static final String HTTP_METHOD = "POST";
	
	public static NewDirectMessage.Response sendRequest(NewDirectMessage.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException{
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		NewDirectMessage.Response response = new NewDirectMessage.Response(twitterResponse.getResponse());		
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
		private String userId;
		private String screenName;
		private String text;
		
		public String getUserId() {
			return userId;
		}
		
		/***
		 * The ID of the user who should receive the direct message.
		 * Helpful for disambiguating when a valid user ID is also a valid screen name.
		 * 
		 * @param userId
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		public String getScreenName() {
			return screenName;
		}
		
		/***
		 * The screen name of the user who should receive the direct message.
		 * Helpful for disambiguating when a valid screen name is also a user ID.
		 * 
		 * @param screenName
		 */
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
		
		public String getText() {
			return text;
		}
		
		/***
		 * The text of your direct message. Be sure to URL encode as necessary, and keep the message under 140 characters.
		 * @param text
		 */
		public void setText(String text) {
			this.text = text;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			
			if(this.screenName != null && !this.screenName.equals("")) {
				htResult.put("screen_name", this.screenName);
			}
			
			if(this.userId != null && !this.userId.equals("")) {
				htResult.put("user_id", this.userId);
			}
			
			if(this.text != null && !this.text.equals("")) {
				htResult.put("text", this.text);
			}
			
			return htResult;
		}
		
		
	}
}
