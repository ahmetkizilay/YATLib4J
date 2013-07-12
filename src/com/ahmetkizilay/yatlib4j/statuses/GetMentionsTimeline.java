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
	
public class GetMentionsTimeline {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/mentions_timeline.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetMentionsTimeline.Response sendRequest(GetMentionsTimeline.Parameters params, OAuthHolder oauthHolder) {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		GetMentionsTimeline.Response response = new GetMentionsTimeline.Response(twitterResponse.getResponse());
		
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
		private String contributorDetails;
		private String includeEntities;
		
		public String getCount() {
			return count;
		}
		
		/***
		 * Specifies the number of tweets to try and retrieve, up to a maximum of 200. <p> 
		 * The value of count is best thought of as a limit to the number of tweets to <p>
		 * return because suspended or deleted content is removed after the count has <p>
		 * been applied. We include retweets in the count, even if include_rts is not <p>
		 * supplied. It is recommended you always send <code>include_rts=1</code> when using this API <p>
		 * method. <p>
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
		 * Returns results with an ID greater than (that is, more recent than) the specified <p> 
		 * ID. There are limits to the number of Tweets which can be accessed through the API. <p>
		 * If the limit of Tweets has occured since the <code>since_id</code>, the <code>since_id</code> will be forced <p> 
		 * to the oldest ID available. <p>
	     * <p>
	     * <strong>Example Values:<strong> 12345 <p>
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
		 * Returns results with an ID less than (that is, older than) or equal to the specified ID. <p>
		 * <p>
		 * <strong>Example Values:</strong> 54321 <p>
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
		 * When set to either true, t or 1, each tweet returned in a timeline will include a user <p> 
		 * object including only the status authors numerical ID. Omit this parameter to receive <p>
		 * the complete user object. <p>
		 * <p>
		 * <strong>Example Values:</strong> true <p>
		 * 
		 * @param trimUser
		 */
		public void setTrimUser(String trimUser) {
			this.trimUser = trimUser;
		}
		
		public String getContributorDetails() {
			return contributorDetails;
		}
		
		/***
		 * This parameter enhances the contributors element of the status response to include the <p>
		 * <code>screen_name</code> of the contributor. By default only the <code>user_id</code> of the contributor is included. <p>
	     * <p>
	     * <strong>Example Values:</strong> true<p>
		 * 
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
		 * <strong>Example Values:</strong> false <p>
		 * 
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
