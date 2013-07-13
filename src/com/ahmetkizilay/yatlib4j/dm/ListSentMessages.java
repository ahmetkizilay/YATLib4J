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

public class ListSentMessages {
	private static final String BASE_URL = "https://api.twitter.com/1.1/direct_messages/sent.json";
	private static final String HTTP_METHOD = "GET";
	
	public static ListSentMessages.Response sendRequest(ListSentMessages.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		ListSentMessages.Response response = new ListSentMessages.Response(twitterResponse.getResponse());		
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
		private String page;
		private String includeEntities;
		
		public String getSinceId() {
			return sinceId;
		}
		
		/***
		 * Returns results with an ID greater than (that is, more recent than) the specified ID.
		 * There are limits to the number of Tweets which can be accessed through the API. If the
		 * limit of Tweets has occured since the since_id, the since_id will be forced to the oldest ID available.
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
		 * Specifies the number of records to retrieve. Must be less than or equal to 200.
		 * 
		 * @param count
		 */
		public void setCount(String count) {
			this.count = count;
		}
		
		public String getPage() {
			return page;
		}
		
		/***
		 * Specifies the page of results to retrieve.
		 * @param page
		 */
		public void setPage(String page) {
			this.page = page;
		}
		
		public String getIncludeEntities() {
			return includeEntities;
		}
		
		/***
		 * The entities node will not be included when set to false.
		 * @param includeEntities
		 */
		public void setIncludeEntities(String includeEntities) {
			this.includeEntities = includeEntities;
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
			if(this.page != null && !this.page.equals("")) {
				htResult.put("page", this.page);
			}
			if(this.sinceId != null && !this.sinceId.equals("")) {
				htResult.put("since_id", this.sinceId);
			}
							
			return htResult;
		}
		
	}
}
