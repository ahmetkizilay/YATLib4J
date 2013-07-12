package com.ahmetkizilay.yatlib4j.application;

import java.util.Hashtable;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.datatypes.RateLimitStatus;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.AppAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetRateLimitStatus {
	private static final String BASE_URL = "https://api.twitter.com/1.1/application/rate_limit_status.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetRateLimitStatus.Response sendRequest(GetRateLimitStatus.Parameters params, AppAuthHolder appAuthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String authHeader = appAuthHolder.getTokenType() + " " + appAuthHolder.getAccessToken();
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequestAppAuth(HTTP_METHOD, BASE_URL, httpParams, authHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		GetRateLimitStatus.Response response = new GetRateLimitStatus.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static GetRateLimitStatus.Response sendRequest(GetRateLimitStatus.Parameters params, OAuthHolder oauthHolder) {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		GetRateLimitStatus.Response response = new GetRateLimitStatus.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static class Response {
		private String rawResponse;
		private Hashtable<String, Hashtable<String, RateLimitStatus>> resourcesTable = new Hashtable<String, Hashtable<String, RateLimitStatus>>();
		
		public Response(String rawResponse) {
			this.rawResponse = rawResponse;
			init();
		}
		
		private void init() {
			JSONObject jsonResponse = (JSONObject) JSONValue.parse(this.rawResponse);
			JSONObject jsonResources = (JSONObject) jsonResponse.get("resources");
			if(jsonResources.containsKey("followers")) {
				JSONObject jsonObjFollowers = (JSONObject) jsonResources.get("followers");
				
				resourcesTable.put("followers", initFollowersResources(jsonObjFollowers));
			}
			if(jsonResources.containsKey("statuses")) {
				JSONObject jsonObjFollowers = (JSONObject) jsonResources.get("statuses");
				
				resourcesTable.put("statuses", initStatusesResources(jsonObjFollowers));
			}
		}
		
		private Hashtable<String, RateLimitStatus> initStatusesResources(JSONObject jsonFollowers) {
			Hashtable<String, RateLimitStatus> result = new Hashtable<String, RateLimitStatus>();
			
			if(jsonFollowers.containsKey("/statuses/user_timeline")) {
				JSONObject jsonFollowersList = (JSONObject) jsonFollowers.get("/statuses/user_timeline");
				RateLimitStatus rts = new RateLimitStatus();
				rts.setLimit((int) jsonFollowersList.get("limit"));
				rts.setRemaining((int) jsonFollowersList.get("remaining"));
				rts.setReset((int) jsonFollowersList.get("reset"));
				result.put("/statuses/user_timeline", rts);
			}
					
			return result;
		}
		
		private Hashtable<String, RateLimitStatus> initFollowersResources(JSONObject jsonFollowers) {
			Hashtable<String, RateLimitStatus> result = new Hashtable<String, RateLimitStatus>();
			
			if(jsonFollowers.containsKey("/followers/list")) {
				JSONObject jsonFollowersList = (JSONObject) jsonFollowers.get("/followers/list");
				RateLimitStatus rts = new RateLimitStatus();
				rts.setLimit((int) jsonFollowersList.get("limit"));
				rts.setRemaining((int) jsonFollowersList.get("remaining"));
				rts.setReset((int) jsonFollowersList.get("reset"));
				result.put("/followers/list", rts);
			}
			
			if(jsonFollowers.containsKey("/followers/ids")) {
				JSONObject jsonFollowersList = (JSONObject) jsonFollowers.get("/followers/ids");
				RateLimitStatus rts = new RateLimitStatus();
				rts.setLimit((int) jsonFollowersList.get("limit"));
				rts.setRemaining((int) jsonFollowersList.get("remaining"));
				rts.setReset((int) jsonFollowersList.get("reset"));
				result.put("/followers/ids", rts);
			}
			
			return result;
		}
		
		public String getRawResponse() {
			return this.rawResponse;
		}
		
		public Hashtable<String, Hashtable<String, RateLimitStatus>> getResourcesTable() {
			return this.resourcesTable;
		}
	}
	
	public static class Parameters  {
		
		private String resources;
		
		public String getResources() {
			return this.resources;
		}
		
		/***
		 * A comma-separated list of resource families you want to know the current rate limit disposition for.
		 * For best performance, only specify the resource families pertinent to your application.See Rate Limiting in API v1.1
		 * for more information.
		 * 
		 * @param resources
		 */
		public void setResources(String resources) {
			this.resources = resources;
		}
		
		/***
		 * A comma-separated list of resource families you want to know the current rate limit disposition for.
		 * For best performance, only specify the resource families pertinent to your application.See Rate Limiting in API v1.1
		 * for more information.
		 * 
		 * @param resources
		 */
		public void setResources(String[] resourceArray) {
			if(resourceArray != null && resourceArray.length > 0) {
				StringBuilder sb = new StringBuilder();
				for(String resource : resourceArray) {
					sb.append(resource); sb.append(",");
				}
				
				sb.setLength(sb.length() - 1);
				this.resources = sb.toString();
			}
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
					
			if(this.resources != null && !this.resources.equals("")) {
				htResult.put("resources", this.resources);
			}
						
			return htResult;
		}
	}
}
