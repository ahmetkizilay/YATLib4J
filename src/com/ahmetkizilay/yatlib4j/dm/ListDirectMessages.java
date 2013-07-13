package com.ahmetkizilay.yatlib4j.dm;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.datatypes.Tweet;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class ListDirectMessages {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages.json";
	private static final String HTTP_METHOD = "GET";
	
	public static ListDirectMessages.Response sendRequest(ListDirectMessages.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException{
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		ListDirectMessages.Response response = new ListDirectMessages.Response(twitterResponse.getResponse());		
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
		
		public ArrayList<Tweet> getDirectMessageList() {
			JSONArray jsonArray = (JSONArray) JSONValue.parse(this.mRawResponse);
			ArrayList<Tweet> result = new ArrayList<Tweet>();
			for(int i = 0, len = jsonArray.size(); i < len; ++i) {
				result.add(Tweet.fromJSON((JSONObject) jsonArray.get(i)));
			}
			return result;
		}
	}
	
	public static class Parameters  {
		private String sinceId;
		private String maxId;
		private String count;
		private String includeEntities;
		private String skipStatus;
		
		public String getSinceId() {
			return sinceId;
		}
		
		/***
		 * Returns results with an ID greater than (that is, more recent than) the specified ID.
		 * There are limits to the number of Tweets which can be accessed through the API. If the
		 * limit of Tweets has occured since the since_id, the since_id will be forced to the oldest
		 * ID available.
		 * 
		 * @param sinceId
		 */
		public void setSinceId(String sinceId) {
			this.sinceId = sinceId;
		}
		
		public String getMaxId() {
			return maxId;
		}

		/***
		 * Returns results with an ID less than (that is, older than) or equal to the specified ID.
		 * @param maxId
		 */
		public void setMaxId(String maxId) {
			this.maxId = maxId;
		}
		
		public String getCount() {
			return count;
		}
		
		/***
		 * Specifies the number of direct messages to try and retrieve, up to a maximum of 200.
		 * The value of count is best thought of as a limit to the number of Tweets to return
		 * because suspended or deleted content is removed after the count has been applied.
		 * 
		 * @param count
		 */
		public void setCount(String count) {
			this.count = count;
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
		
		public String getSkipStatus() {
			return skipStatus;
		}
		
		/***
		 * When set to either true, t or 1 statuses will not be included in the returned user objects.
		 * 
		 * @param skipStatus
		 */
		public void setSkipStatus(String skipStatus) {
			this.skipStatus = skipStatus;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			

			if(this.count != null && !this.count.equals("")) {
				htResult.put("count", this.count);
			}
			if(this.includeEntities != null && !this.includeEntities.equals("")) {
				htResult.put("include_entities", this.includeEntities);
			}
			if(this.maxId != null && !this.maxId.equals("")) {
				htResult.put("max_id", this.maxId);
			}
			if(this.sinceId != null && !this.sinceId.equals("")) {
				htResult.put("since_id", this.sinceId);
			}
			
			if(this.skipStatus != null && !this.skipStatus.equals("")) {
				htResult.put("skip_status", this.skipStatus);
			}
			
			return htResult;
		}
		
		
	}
}
