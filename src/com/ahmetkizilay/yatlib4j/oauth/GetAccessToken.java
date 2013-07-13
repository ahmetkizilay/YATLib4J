package com.ahmetkizilay.yatlib4j.oauth;

import java.util.Hashtable;

import com.ahmetkizilay.yatlib4j.TwitterRequestWrapper;
import com.ahmetkizilay.yatlib4j.TwitterResponseWrapper;
import com.ahmetkizilay.yatlib4j.exceptions.TwitterIOException;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;
import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthUtils;

public class GetAccessToken {
	private static final String BASE_URL = "https://api.twitter.com/oauth/access_token";
	private static final String HTTP_METHOD = "POST"; 
	
	public static GetAccessToken.Response sendRequest(GetAccessToken.Parameters params, OAuthHolder oauthHolder) throws TwitterIOException {
		Hashtable<String, String> httpParams = params.prepareParams();
		
		String oauthHeader = OAuthUtils.generateOAuthHeader(HTTP_METHOD, BASE_URL, httpParams, oauthHolder);
		
		TwitterResponseWrapper twitterResponse = TwitterRequestWrapper.sendRequest(HTTP_METHOD, BASE_URL, httpParams, oauthHeader);
		if(!twitterResponse.isSuccess()) {
			throw new TwitterIOException(twitterResponse.getResponseCode(), twitterResponse.getResponseMessage());
		}
		
		GetAccessToken.Response response = new GetAccessToken.Response(twitterResponse.getResponse());
		
		return response;
	}	
	
	public static class Response {
		private String mRawResponse;
		private String mOAuthToken;
		private String mOAuthTokenSecret;
		private String mUserId;
		private String mScreenName;
		
		public Response(String rawResponse) {
			this.mRawResponse = rawResponse;
			init();
		}
		
		private void init() {
			String[] parts = this.mRawResponse.split("&");
			for(int i = 0, len = parts.length; i < len; ++i) {
				if(parts[i].startsWith("oauth_token=")) {
					this.mOAuthToken = parts[i].substring(12);
				}
				else if(parts[i].startsWith("oauth_token_secret=")) {
					this.mOAuthTokenSecret = parts[i].substring(19);
				}
				else if(parts[i].startsWith("user_id=")) {
					this.mUserId = parts[i].substring(8);
				}
				else if(parts[i].startsWith("screen_name=")) {
					this.mScreenName = parts[i].substring(12);
				}
			}
		}
		
		public String getRawResponse() {
			return this.mRawResponse;
		}
		
		public String getOAuthToken() {
			return this.mOAuthToken;
		}
		
		public String getOAuthTokenSecret() {
			return this.mOAuthTokenSecret;
		}
		
		public String getUserId() {
			return this.mUserId;
		}
		
		public String getScreenName() {
			return this.mScreenName;
		}
	}
	
	public static class Parameters  {
		private String mXAuthPassword;
		private String mXAuthUsername;
		private String mXAuthMode;
		private String mOAuthVerifier;
		
		public String getmXAuthPassword() {
			return mXAuthPassword;
		}
		
		/***
		 * The password of the user for which to obtain a token for. Required when using xAuth
		 * @param mXAuthPassword
		 */
		public void setmXAuthPassword(String mXAuthPassword) {
			this.mXAuthPassword = mXAuthPassword;
		}
		
		public String getmXAuthUsername() {
			return mXAuthUsername;
		}
		
		/***
		 * The username of the user to obtain a token for. Required when using xAuth
		 * @param mXAuthUsername
		 */
		public void setmXAuthUsername(String mXAuthUsername) {
			this.mXAuthUsername = mXAuthUsername;
		}
		
		public String getmXAuthMode() {
			return mXAuthMode;
		}
		
		/***
		 * Set this value to client_auth, without the quotes. Required when using xAuth
		 * 
		 * @param mXAuthMode
		 */
		public void setmXAuthMode(String mXAuthMode) {
			this.mXAuthMode = mXAuthMode;
		}
		
		public String getmOAuthVerifier() {
			return mOAuthVerifier;
		}
		
		/***
		 * If using the OAuth web-flow, set this parameter to the value of the oauth_verifier
		 * returned in the callback URL. If you are using out-of-band OAuth, set this value to the
		 * pin-code. When using xAuth, this value should not be included. For OAuth 1.0a compliance
		 * this parameter is required unless you are using xAuth. Currently Twitter supports both
		 * OAuth 1.0 and OAuth 1.0a which means we do not error if this value isn't included. OAuth 1.0a
		 * is now strictly enforced and applications not using the oauth_verifier will fail to complete
		 * the OAuth flow. If you're not receiving an oauth_verifier in your callback, verify that you're
		 * explicitly setting your oauth_callback on POST oauth/request_token.
		 * 
		 * @param mOAuthVerifier
		 */
		public void setmOAuthVerifier(String mOAuthVerifier) {
			this.mOAuthVerifier = mOAuthVerifier;
		}
		
		public Hashtable<String, String> prepareParams() {
			Hashtable<String, String> htResult = new Hashtable<String, String>();
					
			if(this.mOAuthVerifier != null && !this.mOAuthVerifier.equals("")) {
				htResult.put("oauth_verifier", this.mOAuthVerifier);
			}
			
			if(this.mXAuthMode != null && !this.mXAuthMode.equals("")) {
				htResult.put("x_auth_mode", this.mXAuthMode);
			}
			
			if(this.mXAuthPassword != null && !this.mXAuthPassword.equals("")) {
				htResult.put("x_auth_password", this.mXAuthPassword);
			}
			
			if(this.mXAuthUsername != null && !this.mXAuthUsername.equals("")) {
				htResult.put("x_auth_username", this.mXAuthUsername);
			}
						
			return htResult;
		}
	}
}
