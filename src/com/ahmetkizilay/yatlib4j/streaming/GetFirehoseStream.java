package com.ahmetkizilay.yatlib4j.streaming;

import com.ahmetkizilay.yatlib4j.oauthhelper.OAuthHolder;

public class GetFirehoseStream {
	private static final String BASE_URL = "https://stream.twitter.com/1.1/statuses/firehose.json";
	private static final String HTTP_METHOD = "GET";
	
	public static GetFirehoseStream.Response sendRequest(GetFirehoseStream.Parameters params, OAuthHolder oauthHolder) {
		throw new UnsupportedOperationException();
	}	
	
	public static class Response {
		
	}
	
	public static class Parameters  {
		
	}
}
