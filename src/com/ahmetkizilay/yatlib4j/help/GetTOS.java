package com.ahmetkizilay.yatlib4j.help;

import java.util.Hashtable;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;


public class GetTOS {
	private static final String BASE_URL = "https://api.twitter.com/1.1/help/tos.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetTOS.Response sendRequest(GetTOS.Parameters params, OAuthHolder oauthHolder) {
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		
		GetTOS.Response response = new GetTOS.Response(twitterResponse.getResponse());
		
		return response;
	}
	
	/***
	 * Currently this method does not need parameters
	 * @author ahmetkizilay
	 *
	 */
	public static class Parameters {
		
		public Hashtable<String, String> prepareParams() {
			return new Hashtable<String, String>();
		}
	}
	
	public static class Response {
		private JSONObject jsonData;
		private String rawResponse;
		
		public Response(String rawResponse) {
			this.rawResponse = rawResponse;
			init();
		}
		
		private void init() {			
			 this.jsonData = (JSONObject) JSONValue.parse(this.rawResponse);
		}
		
		public String getRawResponse() {
			return this.rawResponse;
		}
		
		
		public String getTOS() {
			return (String) this.jsonData.get("tos");
		}
	}
}
