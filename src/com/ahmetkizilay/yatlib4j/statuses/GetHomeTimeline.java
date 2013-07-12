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

public class GetHomeTimeline {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/home_timeline.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetHomeTimeline.Response sendRequest(GetHomeTimeline.Parameters params, OAuthHolder oauthHolder) {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		GetHomeTimeline.Response response = new GetHomeTimeline.Response(twitterResponse.getResponse());
		
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
		private String excludeReplies;
		private String contributorDetails;
		private String includeEntities;
		
		public String getCount() {
			return count;
		}
		
		/***
		 * Specifies the number of records to retrieve. Must be less than or equal to 200.<p>
		 * Defaults to 20.<p>
		 * <p>
		 * <strong>Example Values:</strong> 5<p>
		 * 
		 * @param count
		 */
		public void setCount(String count) {
			this.count = count;
		}
		
		public String getSinceId() {
			return sinceId;
		}
		
		/***
		 * Returns results with an ID greater than (that is, more recent than) the specified ID.<p>
		 * There are limits to the number of Tweets which can be accessed through the API. If the<p>
		 * limit of Tweets has occured since the since_id, the since_id will be forced to the oldest<p>
		 * ID available.<p>
		 * <p>
		 * <strong>Example Values:</strong> 12345<p>
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
		 * Returns results with an ID less than (that is, older than) or equal to the specified ID.<p>
		 * <p>
		 * <strong>Example Values:</strong> 54321<p>
		 * 
		 * @param maxId
		 */
		public void setMaxId(String maxId) {
			this.maxId = maxId;
		}
		
		public String getTrimUser() {
			return trimUser;
		}
		
		/***
		 * When set to either true, t or 1, each tweet returned in a timeline will include<p>
		 * a user object including only the status authors numerical ID. Omit this parameter<p>
		 * to receive the complete user object.<p>
		 * <p>
		 * <strong>Example Values:</strong> true<p>
		 * @param trimUser
		 */
		public void setTrimUser(String trimUser) {
			this.trimUser = trimUser;
		}
		
		public String getExcludeReplies() {
			return excludeReplies;
		}
		
		/***
		 * This parameter will prevent replies from appearing in the returned timeline. Using<p> 
		 * <code>exclude_replies</code> with the count parameter will mean you will receive up-to count<p> 
		 * tweets — this is because the count parameter retrieves that many tweets before<p> 
		 * filtering out retweets and replies.<p>
		 * <p>
		 * <strong>Example Values:</strong> true<p>
		 * 
		 * @param excludeReplies
		 */
		public void setExcludeReplies(String excludeReplies) {
			this.excludeReplies = excludeReplies;
		}
		
		public String getContributorDetails() {
			return contributorDetails;
		}
		
		/***
		 * This parameter enhances the contributors element of the status response to include the<p>
		 * <code>screen_name</code> of the contributor. By default only the <code>user_id</code> of the contributor is included.<p>
		 * <p>
		 * <strong>Example Values:</strong> true<p>
		 * @param contributorDetails
		 */
		public void setContributorDetails(String contributorDetails) {
			this.contributorDetails = contributorDetails;
		}
		
		public String getIncludeEntities() {
			return includeEntities;
		}
		
		/***
		 * The entities node will be disincluded when set to false.<p>
		 * <p>
		 * <strong>Example Values:</strong> false<p>
		 * @param includeEntities
		 */
		public void setIncludeEntities(String includeEntities) {
			this.includeEntities = includeEntities;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			
			if(this.contributorDetails != null && !this.contributorDetails.equals("")) {
				htResult.put("contributor_details", this.contributorDetails);
			}
			
			if(this.count != null && !this.count.equals("")) {
				htResult.put("count", this.count);
			}
			
			if(this.excludeReplies != null && !this.excludeReplies.equals("")) {
				htResult.put("exclude_replies", this.excludeReplies);
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
			
			if(this.trimUser != null && !this.trimUser.equals("")) {
				htResult.put("trim_user", this.trimUser);
			}
			
			return htResult;
		}
	}
}
