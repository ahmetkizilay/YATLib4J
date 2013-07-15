package com.ahmetkizilay.yatlib4j.statuses;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.datatypes.Tweet;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.AppAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;
import com.ahmetkizilay.yatlib4j.utils.GenericUtils;

public class GetUserTimeline {
	private static final String BASE_URL = "https://api.twitter.com/1.1/statuses/user_timeline.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetUserTimeline.Response sendRequest(GetUserTimeline.Parameters params, AppAuthHolder appAuthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String authHeader = appAuthHolder.getTokenType() + " ";
		try {
			authHeader += GenericUtils.percentEncode(appAuthHolder.getAccessToken());
		}
		catch(Exception exp) {
			throw new TwitterIOException(0, "Unable To Encode Access Token");
		}
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequestAppAuth(HTTP_METHOD, BASE_URL, httpParams, authHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		GetUserTimeline.Response response = new GetUserTimeline.Response(twitterResponse.getResponse());		
		return response;
	}
	
	public static GetUserTimeline.Response sendRequest(GetUserTimeline.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		GetUserTimeline.Response response = new GetUserTimeline.Response(twitterResponse.getResponse());
		
		return response;
	}
	
	public static class Parameters {
		private String userId;
		private String screenName;
		private String sinceId;
		private String count;
		private String maxId;
		private String trimUser;
		private String excludeReplies;
		private String contributorDetails;
		private String includeRts;
		
		public String getUserId() {
			return userId;
		}
		
		/***
		 * The ID of the user for whom to return results for. <p>
		 * <p>
		 * <strong>Example Values:</strong> 12345 <p>
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
		 * The screen name of the user for whom to return results for. <p>
		 * <p>
		 * <strong>Example Values:</strong> noradio <p>
		 * 
		 * @param userId
		 */
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
		
		public String getSinceId() {
			return sinceId;
		}
		
		/***
		 * Returns results with an ID greater than (that is, more recent than) the specified ID. <p> 
		 * There are limits to the number of Tweets which can be accessed through the API. <p>
		 * If the limit of Tweets has occured since the since_id, the since_id will be forced <p> 
		 * to the oldest ID available. <p>
		 * <p>
		 * <strong>Example Values:</strong> 12345 <p>
		 * 
		 * @param sinceId
		 */
		public void setSinceId(String sinceId) {
			this.sinceId = sinceId;
		}
		
		public String getCount() {
			return count;
		}
		
		/***
		 * Specifies the number of tweets to try and retrieve, up to a maximum of 200 per <p> 
		 * distinct request. The value of count is best thought of as a limit to the number <p>
		 * of tweets to return because suspended or deleted content is removed after the  <p>
		 * count has been applied. We include retweets in the count, even if <code>include_rts</code> <p>
		 * is not supplied. It is recommended you always send <code>include_rts=1</code> when using <p>
		 * this API method. <p>
		 * <p>
		 * @param count
		 */
		public void setCount(String count) {
			this.count = count;
		}
		
		public String getMaxId() {
			return maxId;
		}
		
		/***
		 * Returns results with an ID less than (that is, older than) or equal to the specified<p> 
		 * ID.<p>
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
		 * When set to either true, t or 1, each tweet returned in a timeline will include a<p> 
		 * user object including only the status authors numerical ID. Omit this parameter to <p>
		 * receive the complete user object.<p>
		 * <p>
		 * <strong>Example Values:</strong> true<p>
		 * 
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
		 * exclude_replies with the count parameter will mean you will receive up-to count <p>
		 * tweets — this is because the count parameter retrieves that many tweets before filtering<p> 
		 * out retweets and replies. This parameter is only supported for JSON and XML responses.<p>
		 * <p>
		 * <strong>Example Values:</strong> true<p>
		 * 
		 * @param exludeReplies
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
		 * 
		 * @param contributorDetails
		 */
		public void setContributorDetails(String contributorDetails) {
			this.contributorDetails = contributorDetails;
		}
		
		public String getIncludeRts() {
			return includeRts;
		}
		
		/***
		 * When set to false, the timeline will strip any native retweets (though they will still count 
		 * toward both the maximal length of the timeline and the slice selected by the count parameter). 
		 * Note: If you're using the trim_user parameter in conjunction with include_rts, the retweets 
		 * will still contain a full user object.
         * 
         * Example Values: false
		 * 
		 * @param includeRts
		 */
		public void setIncludeRts(String includeRts) {
			this.includeRts = includeRts;
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
			if(this.includeRts != null && !this.includeRts.equals("")) {
				htResult.put("include_rts", this.includeRts);
			}
			if(this.maxId != null && !this.maxId.equals("")) {
				htResult.put("max_id", this.maxId);
			}
			if(this.screenName != null && !this.screenName.equals("")) {
				htResult.put("screen_name", this.screenName);
			}
			if(this.sinceId != null && !this.sinceId.equals("")) {
				htResult.put("since_id", this.sinceId);
			}
			if(this.trimUser != null && !this.trimUser.equals("")) {
				htResult.put("trim_user", this.trimUser);
			}
			if(this.userId != null && !this.userId.equals("")) {
				htResult.put("user_id", this.userId);
			}
			
			return htResult;
		}
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
}
