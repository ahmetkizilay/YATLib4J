package com.ahmetkizilay.yatlib4j.users;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.datatypes.Users;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class LookupUsers {
	private static final String BASE_URL = "https://api.twitter.com/1.1/users/lookup.json";
	private static final String HTTP_METHOD = "POST"; 
	
	public static LookupUsers.Response sendRequest(LookupUsers.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		LookupUsers.Response response = new LookupUsers.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static class Response {
		private JSONArray jsonResponse;
		
		public Response(String rawResponse) {
			this.jsonResponse = (JSONArray) JSONValue.parse(rawResponse);			
		}
			
		public ArrayList<Users> getUsers(boolean includeData) {
			ArrayList<Users> users = new ArrayList<Users>();
			for(int i = 0, len = this.jsonResponse.size(); i < len; ++i) {
				JSONObject userObject = (JSONObject) this.jsonResponse.get(i);
				users.add(Users.fromJSONObject(userObject, includeData));
			}
			return users;
		}
	}
	
	public static class Parameters  {
		private String screenName;
		private String userId;
		private String includeEntities;
		
		public String getScreenName() {
			return screenName;
		}
		
		/***
		 * A comma separated list of screen names, up to 100 are allowed in a single request.
		 * You are strongly encouraged to use a POST for larger (up to 100 screen names) requests.
		 * 
		 * @param screenName
		 */
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
		
		/***
		 * A comma separated list of screen names, up to 100 are allowed in a single request.
		 * You are strongly encouraged to use a POST for larger (up to 100 screen names) requests.
		 * 
		 * @param screenName
		 */
		public void setScreenName(String[] screenNameArray) {
			if(screenNameArray != null && screenNameArray.length > 0) {
				StringBuilder sb = new StringBuilder();
				for(String screenNameItem : screenNameArray) {
					sb.append(screenNameItem); sb.append(",");
				}
				
				sb.setLength(sb.length() - 1);
				this.screenName = sb.toString();
			}
		}
		
		public String getUserId() {
			return userId;
		}
		
		/***
		 * A comma separated list of user IDs, up to 100 are allowed in a single request.
		 * You are strongly encouraged to use a POST for larger requests.
		 * 
		 * @param userId
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		/***
		 * A comma separated list of user IDs, up to 100 are allowed in a single request.
		 * You are strongly encouraged to use a POST for larger requests.
		 * 
		 * @param userId
		 */
		public void setUserId(String[] userIdArray) {
			if(userIdArray != null && userIdArray.length > 0) {
				StringBuilder sb = new StringBuilder();
				for(String userIdItem : userIdArray) {
					sb.append(userIdItem); sb.append(",");
				}
				
				sb.setLength(sb.length() - 1);
				this.userId = sb.toString();
			}
		}
		
		
		public String getIncludeEntities() {
			return includeEntities;
		}
		
		/***
		 * The entities node that may appear within embedded statuses will be disincluded when set to false.
		 * 
		 * @param includeEntities
		 */
		public void setIncludeEntities(String includeEntities) {
			this.includeEntities = includeEntities;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			
			
			if(this.screenName != null && !this.screenName.equals("")) {
				htResult.put("screen_name", this.screenName);
			}
			
			if(this.userId != null && !this.userId.equals("")) {
				htResult.put("user_id", this.userId);
			}
			
			if(this.includeEntities != null && !this.includeEntities.equals("")) {
				htResult.put("include_entities", this.includeEntities);
			}
			
			return htResult;
		}
		
	}
}
