package com.ahmetkizilay.yatlib4j.users.suggestions;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.datatypes.Slug;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetSuggestionCategories {
	private static final String BASE_URL = "https://api.twitter.com/1.1/users/suggestions.json";
	private static final String HTTP_METHOD = "GET"; 
	
	public static GetSuggestionCategories.Response sendRequest(GetSuggestionCategories.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException{
		Hashtable<String, String> httpParams = params.prepareParams();
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponse());
		}
		
		GetSuggestionCategories.Response response = new GetSuggestionCategories.Response(twitterResponse.getResponse());		
		return response;
	}	
	
	public static class Response {
		private String mRawResponse;
		
		public Response(String rawResponse) {
			this.mRawResponse = rawResponse;
		}
		
		public ArrayList<Slug> getSlugList() {
			ArrayList<Slug> slugList = new ArrayList<Slug>();
			
			JSONArray jsonSlugArray = (JSONArray) JSONValue.parse(this.mRawResponse);
			for(int i = 0, len = jsonSlugArray.size(); i < len; ++i) {
				slugList.add(Slug.fromJSONObject((JSONObject) jsonSlugArray.get(i)));
			}
			
			return slugList;
		}
	}
	
	public static class Parameters  {
		private String lang;
		
		public String getLang() {
			return this.lang;
		}
		
		/***
		 * Restricts the suggested categories to the requested language. The language must be specified
		 * by the appropriate two letter ISO 639-1 representation. Currently supported languages are
		 * provided by the GET help/languages API request. Unsupported language codes will receive English
		 * (en) results. If you use lang in this request, ensure you also include it when requesting the
		 * GET users/suggestions/:slug list.
		 * 
		 * @param lang
		 */
		public void setLang(String lang) {
			this.lang = lang;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
			if(this.lang != null && !this.lang.equals("")) {
				htResult.put("lang", this.lang);
			}
			return htResult;
		}
	}
}
