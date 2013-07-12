package com.ahmetkizilay.yatlib4j.datatypes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import com.ahmetkizilay.yatlib4j.utils.GenericUtils;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class Tweet {
	private Object annotations;
	private ArrayList<Contributor> contributors;
	private Coordinates coordinates;
	private String createdAt; 
	private Object currentUserRetweet;
	private Entities entities;
	private Integer favoriteCount;
	private Boolean favorited;
	private String filterLevel;
	private Object geo;	
	private BigInteger id;
	private String idStr;
	private String inReplyToScreenName;
	private BigInteger inReplyToStatusId;
	private String inReplyToStatusIdStr; 
	private BigInteger inReplyToUserId;
	private String inReplyToUserIdStr;
	private String lang;
	private Places place;
	private Boolean possiblySensitive;
	private Hashtable<String, String> scope;
	private int retweetCount;
	private boolean retweeted;
	private String source;
	private String text;
	private boolean truncated;
	private Object users; // TODO to be implemented
	private boolean withheldCopyright; // TODO to be implemented
	private Object witheldInCountries; // TODO to be implemented
	private String withheldScope; // TODO to be implemented
	
	private String jsonString;
	
	public String getJSONString() {
		return this.jsonString;
	}
	private void setJSONString(String jsonString) {
		this.jsonString = jsonString;
	}
	
	public Object getAnnotations() {
		return this.annotations;
	}
	
	/***
	 * Unused. Future/beta home for status annotations.<p>
	 * @param annotations
	 */
	public void setAnnotations(Object annotations) {
		this.annotations = annotations;
	}
	
	public ArrayList<Contributor> getContributors() {
		return this.contributors;
	}
	
	/***
	 * Nullable. An collection of brief user objects (usually only one) indicating<p> 
	 * users who contributed to the authorship of the tweet, on behalf of the official tweet author<p>
	 * @param contributors
	 */
	public void setContributors(ArrayList<Contributor> contributors) {
		this.contributors = contributors;
	}	
	
	public Coordinates getCoordinates() {
		return this.coordinates;
	}
	
	/***
	 * Nullable. Represents the geographic location of this Tweet as reported by the user or client<p>
	 * application. The inner coordinates array is formatted as geoJSON (longitude first, then latitude).<p>
	 *
	 * @param coordinates
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public Object getCurrentUserRetweet() {
		return this.currentUserRetweet;
	}
	
	/***
	 * Perspectival. Only surfaces on methods supporting the include_my_retweet parameter, when set<p>
	 * to true. Details the Tweet ID of the user's own retweet (if existent) of this Tweet.<p>
	 * 
	 * TODO Not Really Implemented Yet 
	 * 
	 * @param currentUserRetweet
	 */
	public void setCurrentUserRetweet(Object currentUserRetweet) {
		this.currentUserRetweet = currentUserRetweet;
		
	}
	
	public Entities getEntities() {
		return this.entities;
	}
	
	/***
	 * Entities which have been parsed out of the text of the Tweet. Additionally see Tweet Entities.<p>
	 * 
	 * @return
	 */
	public void setEntities(Entities entities) {
		this.entities = entities;
	}
	
	public Integer getFavoriteCount() {		
		return this.favoriteCount;
	}
	
	/***
	 * Nullable. Indicates approximately how many times this Tweet has been "favorited" by Twitter users.<p>
	 * 
	 * @param favoriteCount
	 */
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	public Boolean getFavorited() {
		return this.favorited;
	}
	
	/***
	 * Nullable. Perspectival. Indicates whether this Tweet has been favorited by the authenticating user.<p>
	 * 
	 * @param favorited
	 */
	public void setFavorited(Boolean favorited) {
		this.favorited = favorited;
	}
		
	public String getFilterLevel() {
		return this.filterLevel;
	}
	
	/***
	 * Indicates the maximum value of the filter_level parameter which may be used and still stream this Tweet.<p>
	 * So a value of medium will be streamed on none, low, and medium streams. See this announcement for more information. <p>
	 * 
	 * @param filterLevel
	 */
	public void setFilterLevel(String filterLevel) {
		this.filterLevel = filterLevel;
	}
	
	@Deprecated
	public Object getGeo() {
		return this.geo;
	}
	

	/***
	 * Deprecated. Nullable. Use the "coordinates" field instead<p>
	 * 
	 * @param geo
	 */
	@Deprecated
	public void setGeo(Object geo) {
		this.geo = geo;
	}

	public BigInteger getId() {
		return this.id;
	}
	
	/***
	 * The integer representation of the unique identifier for this Tweet.<p>
	 * This number is greater than 53 bits and some programming languages may<p>
	 * have difficulty/silent defects in interpreting it. Using a signed 64 bit<p>
	 * integer for storing this identifier is safe. Use id_str for fetching the<p>
	 * identifier to stay on the safe side. See Twitter IDs, JSON and Snowflake.<p>
	 * 
	 * @param id
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getIdStr() {
		return this.idStr;
	}
	
	/***
	 * The string representation of the unique identifier for this Tweet.<p>
	 * Implementations should use this rather than the large integer in id.<p>
	 * 
	 * @param idStr
	 */
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	
	public String getInReplyToScreenName() {
		return this.inReplyToScreenName;
	}
	
	/***
	 * Nullable. If the represented Tweet is a reply, this field will contain the screen name<p>
	 * of the original Tweet's author.<p>
	 * 
	 * @param inReplyToScreenName
	 */
	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}
	
	public BigInteger getInReplyToStatusId() {
		return this.inReplyToStatusId;
	}
	
	/***
	 * Nullable. If the represented Tweet is a reply, this field will contain the integer representation<p>
	 * of the original Tweet's ID.<p>
	 * 
	 * @param inReplyToStatusId
	 */
	public void setInReplyToStatusId(BigInteger inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}
	
	public String getInReplyToStatusIdStr() {
		return this.inReplyToStatusIdStr;
	}
	
	/***
	 * Nullable. If the represented Tweet is a reply, this field will contain the string representation<p>
	 * of the original Tweet's ID.<p>
	 * 
	 * @param inReplyToStatusId
	 */
	public void setInReplyToStatusIdStr(String inReplyToStatusIdStr) {
		this.inReplyToStatusIdStr = inReplyToStatusIdStr;
	}
	
	public BigInteger getInReplyToUserId() {
		return this.inReplyToUserId;
	}
	
	/***
	 * Nullable. If the represented Tweet is a reply, this field will contain the integer representation<p>
	 * of the original Tweet's author ID. This will not necessarily always be the user directly mentioned<p>
	 * in the Tweet.<p>
	 * 
	 * @param inReplyToStatusId
	 */
	public void setInReplyToUserId(BigInteger inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}
	
	public String getInReplyToUserIdStr() {
		return this.inReplyToUserIdStr;
	}
		
	/***
	 * Nullable. If the represented Tweet is a reply, this field will contain the string representation<p>
	 * of the original Tweet's author ID. This will not necessarily always be the user directly mentioned<p>
	 * in the Tweet.<p>
	 * 
	 * @param inReplyToUserIdStr
	 */
	public void setInReplyToUserIdStr(String inReplyToUserIdStr) {
		this.inReplyToUserIdStr = inReplyToUserIdStr;
	}
	
	public String getLang() {
		return this.lang;
	}
	
	/***
	 * Nullable. When present, indicates a BCP 47 language identifier corresponding to the machine-detected<p>
	 * language of the Tweet text, or "und" if no language could be detected.<p>
	 * 
	 * @param lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public Places getPlace() {
		return this.place;
	}
	
	/***
	 * Nullable. When present, indicates that the tweet is associated (but not<p>
	 * necessarily originating from) a Place.<p>
	 * 
	 * @param place
	 */
	public void setPlace(Places place) {
		this.place = place;
	}
	
	public Boolean getPossiblySensitive() {
		return this.possiblySensitive;
	}
	
	/***
	 * Nullable. This field only surfaces when a tweet contains a link. The meaning<p>
	 * of the field doesn't pertain to the tweet content itself, but instead it is an<p>
	 * indicator that the URL contained in the tweet may contain content or media identified<p>
	 * as sensitive content.<p>
	 * 
	 * @param possibleSensitive
	 */
	public void setPossibleSensitive(Boolean possiblySensitive) {
		this.possiblySensitive = possiblySensitive;
	}
	
	public Hashtable<String, String> getScope() {
		return this.scope;
	}
	
	/***
	 * A set of key-value pairs indicating the intended contextual delivery of the containing<p>
	 * Tweet. Currently used by Twitter's Promoted Products.<p>
	 * 
	 * @param scope
	 */
	public void setScope(Hashtable<String, String> scope) {
		this.scope = scope;
	}
	
	public int getRetweetCount() {
		return this.retweetCount;
	}
	
	/***
	 * Number of times this Tweet has been retweeted. This field is no longer capped at 99<p>
	 * and will not turn into a String for "100+"<p>
	 * 
	 * @param retweetCount
	 */
	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}
	
	public boolean isRetweeted() {
		return this.retweeted;
	}
	
	/***
	 * Perspectival. Indicates whether this Tweet has been retweeted by the authenticating user.<p>
	 * 
	 * @param retweeted
	 */
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}
	
	public String getSource() {
		return this.source;
	}
	
	/***
	 * Utility used to post the Tweet, as an HTML-formatted string. Tweets from the Twitter website<p>
	 * have a source value of web.<p>
	 * 
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getText() {
		return this.text;
	}
	
	/***
	 * The actual UTF-8 text of the status update. See twitter-text for details on what is currently<p>
	 * considered valid characters.<p>
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	public boolean getTruncated() {
		return this.truncated;
	}
	
	/***
	 * Indicates whether the value of the text parameter was truncated, for example, as a result of a retweet<p>
	 * exceeding the 140 character Tweet length. Truncated text will end in ellipsis, like this ... Since Twitter<p>
	 * now rejects long Tweets vs truncating them, the large majority of Tweets will have this set to false.<p>
	 * Note that while native retweets may have their toplevel text property shortened, the original text will be<p>
	 * available under the retweeted_status object and the truncated parameter will be set to the value of the original<p>
	 * status (in most cases, false).<p>
	 * 
	 * @param truncated
	 */
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}
	
	
	
	public String getCreatedAt() {
		return this.createdAt;
	}
	
	public Date getCreatedAtDate() throws Exception {
		return GenericUtils.parseDateString(this.createdAt);
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	

	
	public static Tweet fromJSONString(String jsonString) {
		return fromJSONString(jsonString, false);
	}
	
	public static Tweet fromJSONString(String jsonString, boolean keepData) {
		JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
		return fromJSON(jsonObject, keepData);
	}
	
	public static Tweet fromJSON(JSONObject jsonData) {
		return fromJSON(jsonData, false);
	}
	
	public static Tweet fromJSON(JSONObject jsonData, boolean keepData) {
		
		Tweet tweet = new Tweet();
		tweet.setIdStr((String) jsonData.get("id_str"));
		tweet.setText((String) jsonData.get("text"));
		tweet.setCreatedAt((String) jsonData.get("created_at"));
		tweet.setSource((String)jsonData.get("source"));
		
		if(keepData) {
			tweet.setJSONString(jsonData.toJSONString());
		}
		return tweet;
	}
}
