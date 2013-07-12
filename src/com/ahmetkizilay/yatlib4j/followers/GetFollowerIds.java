package com.ahmetkizilay.yatlib4j.followers;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetFollowerIds {
	private static final String BASE_URL = "https://api.twitter.com/1.1/followers/ids.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetFollowerIds.Response sendRequest(GetFollowerIds.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		GetFollowerIds.Response response = new GetFollowerIds.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static class Response {
		private String rawResonse;
		private ArrayList<String> strIdList = new ArrayList<String>();
		private String nextCursorStr;
		private String previousCursorStr;
		
		public Response(String strResponse) {
			this.rawResonse = strResponse;
			init();
		}
		
		private void init() {
			JSONObject jsonObj = (JSONObject) JSONValue.parse(this.rawResonse);
			JSONArray jsonIdsArray = (JSONArray) jsonObj.get("ids");
			if(jsonIdsArray != null && jsonIdsArray.size() > 0) {
				if(jsonIdsArray.get(0) instanceof String) {
					for(Object idItem : jsonIdsArray) {
						strIdList.add((String) idItem);
					}
				}
			}
			
			this.nextCursorStr = (String) jsonObj.get("next_cursor_str");
			this.previousCursorStr = (String) jsonObj.get("previous_cursor_str");
			
			
		}
		
		public String getRawResponse() {
			return this.rawResonse;
		}
		
		public String getNextCursorStr() {
			return this.nextCursorStr;
		}
		
		public String getPreviousCursorStr() {
			return this.previousCursorStr;
		}
		
		public ArrayList<String> getStringifiedIds() {
			return this.strIdList;
		}
	}
	
	public static class Parameters  {
		private String userId;
		private String screenName;
		private String cursor;
		private String stringifyIds;
		private String count;
		
		public String getUserId() {
			return userId;
		}
		
		/***
		 * The ID of the user for whom to return results for.<p>
		 * @param userId
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		public String getScreenName() {
			return screenName;
		}
		
		/***
		 * The screen name of the user for whom to return results for.
		 * @param screenName
		 */
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
		
		public String getCursor() {
			return cursor;
		}
		
		/***
		 * Causes the list of connections to be broken into pages of no more than 5000 IDs at a time.<p>
		 * The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out<p>
		 * after connections are queried. If no cursor is provided, a value of -1 will be assumed, which<p>
		 * is the first "page." The response from the API will include a previous_cursor and next_cursor<p>
		 * to allow paging back and forth. See Using cursors to navigate collections for more information.<p>
		 * 
		 * @param cursor
		 */
		public void setCursor(String cursor) {
			this.cursor = cursor;
		}
		
		public String getStringifyIds() {
			return stringifyIds;
		}
		
		/***
		 * Many programming environments will not consume our Tweet ids due to their size. Provide this option<p>
		 * to have ids returned as strings instead. More about Twitter IDs, JSON and Snowflake.<p>
		 * 
		 * @param stringifyIds
		 */
		public void setStringifyIds(String stringifyIds) {
			this.stringifyIds = stringifyIds;
		}
		
		public String getCount() {
			return count;
		}
		
		/***
		 * Specifies the number of IDs attempt retrieval of, up to a maximum of 5,000 per distinct request. The
		 * value of count is best thought of as a limit to the number of results to return. When using the count
		 * parameter with this method, it is wise to use a consistent count value across all requests to the same user's
		 * collection. Usage of this parameter is encouraged in environments where all 5,000 IDs constitutes too large of
		 * a response.<p>
		 * 
		 * @param count
		 */
		public void setCount(String count) {
			this.count = count;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			
			if(this.count != null && !this.count.equals("")) {
				htResult.put("count", this.count);
			}
			
			if(this.cursor != null && !this.cursor.equals("")) {
				htResult.put("cursor", this.cursor);
			}
			
			if(this.screenName != null && !this.screenName.equals("")) {
				htResult.put("screen_name", this.screenName);
			}
			
			if(this.stringifyIds != null && !this.stringifyIds.equals("")) {
				htResult.put("stringify_ids", this.stringifyIds);
			}
			
			if(this.userId != null && !this.userId.equals("")) {
				htResult.put("user_id", this.userId);
			}
						
			return htResult;
		}
		
		
	}
}
