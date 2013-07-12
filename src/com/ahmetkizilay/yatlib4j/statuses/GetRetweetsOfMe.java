package com.ahmetkizilay.yatlib4j.statuses;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.datatypes.Tweet;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetRetweetsOfMe {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/retweets_of_me.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetRetweetsOfMe.Response sendRequest(GetRetweetsOfMe.Parameters params, OAuthHolder oauthHolder) {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		GetRetweetsOfMe.Response response = new GetRetweetsOfMe.Response(twitterResponse.getResponse());
		
		return response;
	}
	
	public static class Response {
		private JSONArray jsonData;
		private String rawResponse;
		
		public Response(String rawResponse) {
			this.rawResponse = rawResponse;
			init();
		}
		
		private void init() {			
			 this.jsonData = (JSONArray) JSONValue.parse(this.rawResponse);
		}
		
		public String getRawResponse() {
			return this.rawResponse;
		}
		
		public ArrayList<Tweet> getTweets() {
			return getTweets(false);
		}
		
		public ArrayList<Tweet> getTweets(boolean withJSONData) {
			ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
			for(int i = 0, len = jsonData.size(); i < len; ++i) {
				Tweet tweet = Tweet.fromJSON((JSONObject)jsonData.get(i), withJSONData);
				tweetList.add(tweet);
			}
			return tweetList;
		}		
	}
	
	public static class Parameters {
		private String count;
		private String sinceId;
		private String maxId;
		private String trimUser;
		private String includeEntities;
		private String includeUserEntities;
		
		public String getCount() {
			return count;
		}
		
		public void setCount(String count) {
			this.count = count;
		}
		
		public String getSinceId() {
			return sinceId;
		}
		
		public void setSinceId(String sinceId) {
			this.sinceId = sinceId;
		}
		
		public String getMaxId() {
			return maxId;
		}
		
		public void setMaxId(String maxId) {
			this.maxId = maxId;
		}
		
		public String getTrimUser() {
			return trimUser;
		}
		
		public void setTrimUser(String trimUser) {
			this.trimUser = trimUser;
		}
		
		public String getIncludeEntities() {
			return includeEntities;
		}
		
		public void setIncludeEntities(String includeEntities) {
			this.includeEntities = includeEntities;
		}
		
		public String getIncludeUserEntities() {
			return includeUserEntities;
		}
		
		public void setIncludeUserEntities(String includeUserEntities) {
			this.includeUserEntities = includeUserEntities;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			
			
			if(this.count != null && !this.count.equals("")) {
				htResult.put("count", this.count);
			}
						
			if(this.includeEntities != null && !this.includeEntities.equals("")) {
				htResult.put("include_entities", this.includeEntities);
			}
			
			if(this.includeUserEntities != null && !this.includeUserEntities.equals("")) {
				htResult.put("include_user_entities", this.includeUserEntities);
			}
			
			if(this.maxId != null && !this.maxId.equals("")) {
				htResult.put("max_id", this.maxId);
			}
			
			if(this.sinceId != null && !this.sinceId.equals("")) {
				htResult.put("since_id", this.sinceId);
			}
			
			if(this.trimUser != null && !this.trimUser.equals("")) {
				htResult.put("trim_user", this.trimUser);
			}
			
			return htResult;
		}
		
		
	}
}
