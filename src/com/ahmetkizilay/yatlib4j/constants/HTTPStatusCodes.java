package com.ahmetkizilay.yatlib4j.constants;

public class HTTPStatusCodes {
	
	/***
	 * Success!
	 */
	public static final int OK = 200;
	
	/***
	 * There was no new data to return.
	 */
	public static final int NOT_MODIFIED = 304;
	
	/***
	 * The request was invalid. An accompanying error message will
	 * explain why. This is the status code will be returned during
	 * version 1.0 rate limiting. In API v1.1, a request without authentication
	 * is considered invalid and you will get this response.
	 */
	public static final int BAD_REQUEST = 400;
	
	/***
	 * Authentication credentials were missing or incorrect.
	 */
	public static final int UNAUTHORIZED = 401;
	
	/***
	 * The request is understood, but it has been refused or access is not allowed. An accompanying
	 * error message will explain why. This code is used when requests are being
	 * denied due to update limits.
	 */
	public static final int FORBIDDEN = 403;
	
	/***
	 * The URI requested is invalid or the resource requested, such as a user, does not exists.
	 * Also returned when the requested format is not supported by the requested method.
	 */
	public static final int NOT_FOUND = 404;
	
	/***
	 * Returned by the Search API when an invalid format is specified in the request.
	 */
	public static final int NOT_ACCEPTABLE = 406;
	
	/***
	 * This resource is gone. Used to indicate that an API endpoint has been turned off.
	 * For example: "The Twitter REST API v1 will soon stop functioning.
	 * Please migrate to API v1.1."
	 */
	public static final int GONE = 410;
	
	/***
	 * Returned by the version 1 Search and Trends APIs when you are being rate limited.
	 */
	public static final int ENHANCE_YOUR_CALM = 420;
	
	/***
	 * Returned when an image uploaded to POST account/update_profile_banner
	 * is unable to be processed.
	 */
	public static final int UNPROCESSABLE_ENTITY = 422;
	
	/***
	 * Returned in API v1.1 when a request cannot be served due to the application's rate
	 * limit having been exhausted for the resource. 
	 */
	public static final int TOO_MANY_REQUESTS = 429;
	
	/***
	 * Something is broken. Please post to the group so the Twitter team can
	 * investigate.
	 */
	public static final int INTERNAL_SERVER_ERROR = 500;
	
	/***
	 * Twitter is down or being upgraded.
	 */
	public static final int BAD_GATEWAY = 502;
	
	/***
	 * The Twitter servers are up, but overloaded with requests.
	 * Try again later.
	 */
	public static final int SERVICE_UNAVAILABLE = 503;
	
	/***
	 * The Twitter servers are up, but the request couldn't be serviced due to
	 * some failure within our stack. Try again later.
	 */
	public static final int GATEWAY_TIMEOUT = 504;	
}
