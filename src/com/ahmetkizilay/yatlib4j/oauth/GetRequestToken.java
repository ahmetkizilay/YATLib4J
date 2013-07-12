package com.ahmetkizilay.yatlib4j.oauth;

import java.util.Hashtable;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetRequestToken {
	private static final String BASE_URL = "https://api.twitter.com/oauth/request_token";
	private static final String HTTP_METHOD = "POST"; 
	
	public static GetRequestToken.Response sendRequest(GetRequestToken.Parameters params, OAuthHolder oauthHolder) {		
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		private String rawResponse;
		
		public Response(String rawResponse) {
			this.rawResponse = rawResponse;
		}
	}
	
	public static class Parameters  {
		private String oAuthCallback;
		private String xAuthAccessType;
		
		public String getOAuthCallback() {
			return this.oAuthCallback;
		}
		
		/***
		 * For OAuth 1.0a compliance this parameter is required. The value you specify here will be used as the URL
		 * a user is redirected to should they approve your application's access to their account. Set this to oob
		 * for out-of-band pin mode. This is also how you specify custom callbacks for use in desktop/mobile applications.
		 * Always send an oauth_callback on this step, regardless of a pre-registered callback.
		 * 
		 * @param oauthCallback
		 */
		public void setOAuthCallback(String oauthCallback) {
			this.oAuthCallback = oauthCallback;
		}
		
		public String getXAuthAccessType() {
			return this.xAuthAccessType;
		}
		
		/***
		 * Overrides the access level an application requests to a users account. Supported values are read or write.
		 * This parameter is intended to allow a developer to register a read/write application but also request read only
		 * access when appropriate.
		 * 
		 * @param xAuthAccessType
		 */
		public void setXAuthAccessType(String xAuthAccessType) {
			this.xAuthAccessType = xAuthAccessType;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
					
			if(this.xAuthAccessType != null && !this.xAuthAccessType.equals("")) {
				htResult.put("x_auth_access_type", this.xAuthAccessType);
			}
			
			if(this.oAuthCallback != null && !this.oAuthCallback.equals("")) {
				htResult.put("oauth_callback", this.oAuthCallback);
			}
						
			return htResult;
		}
		
	}
}
