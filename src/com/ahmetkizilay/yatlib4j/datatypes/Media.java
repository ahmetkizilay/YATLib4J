package com.ahmetkizilay.yatlib4j.datatypes;

import java.math.BigInteger;

public class Media {
	private String displayUrl;
	private String expandedUrl;
	private BigInteger id;
	private String idStr;
	private int[] indiced;
	private String mediaUrl;
	private String mediaUrlHttps;
	private Sizes sizes;
	private BigInteger sourcestatusId;
	private String sourceStatusIdStr;
	private String type;
	private String url;
	
	public String getDisplayUrl() {
		return displayUrl;
	}
	
	/***
	 * URL of the media to display to clients.<p>
	 * 
	 * @param displayUrl
	 */
	public void setDisplayUrl(String displayUrl) {
		this.displayUrl = displayUrl;
	}
	
	public String getExpandedUrl() {
		return expandedUrl;
	}
	
	/***
	 * An expanded version of display_url. Links to the media display page.<p>
	 * 
	 * @param expandedUrl
	 */
	public void setExpandedUrl(String expandedUrl) {
		this.expandedUrl = expandedUrl;
	}
	
	public BigInteger getId() {
		return id;
	}
	
	/***
	 * ID of the media expressed as a 64-bit integer.<p>
	 * 
	 * @param id
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getIdStr() {
		return idStr;
	}
	
	/***
	 * ID of the media expressed as a string.<p>
	 * 
	 * @param idStr
	 */
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	
	public int[] getIndiced() {
		return indiced;
	}
	
	/***
	 * An array of integers indicating the offsets within the Tweet text where the URL<p>
	 * begins and ends. The first integer represents the location of the first character<p>
     * of the URL in the Tweet text. The second integer represents the location of the first<p>
     * non-URL character occurring after the URL (or the end of the string if the URL is the<p>
     * last part of the Tweet text).<p>
     * 
	 * @param indiced
	 */
	public void setIndiced(int[] indiced) {
		this.indiced = indiced;
	}
	
	public String getMediaUrl() {
		return mediaUrl;
	}
	
	/***
	 * An http:// URL pointing directly to the uploaded media file.<p>
	 * 
	 * @param mediaUrl
	 */
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	
	public String getMediaUrlHttps() {
		return mediaUrlHttps;
	}
	
	/***
	 * An https:// URL pointing directly to the uploaded media file, for embedding on https pages.<p>
	 * 
	 * @param mediaUrlHttps
	 */
	public void setMediaUrlHttps(String mediaUrlHttps) {
		this.mediaUrlHttps = mediaUrlHttps;
	}
	
	public Sizes getSizes() {
		return sizes;
	}
	
	/***
	 * An object showing available sizes for the media file.<p>
	 * 
	 * @param sizes
	 */
	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}
	
	public BigInteger getSourcestatusId() {
		return sourcestatusId;
	}
	
	/***
	 * For Tweets containing media that was originally associated with a different tweet,<p>
	 * this ID points to the original Tweet.<p>
	 * 
	 * @param sourcestatusId
	 */
	public void setSourcestatusId(BigInteger sourcestatusId) {
		this.sourcestatusId = sourcestatusId;
	}
	
	public String getSourceStatusIdStr() {
		return sourceStatusIdStr;
	}
	
	/***
	 * For Tweets containing media that was originally associated with a different tweet,<p>
	 * this string-based ID points to the original Tweet.<p>
	 * 
	 * @param sourceStatusIdStr
	 */
	public void setSourceStatusIdStr(String sourceStatusIdStr) {
		this.sourceStatusIdStr = sourceStatusIdStr;
	}
	
	public String getType() {
		return type;
	}
	
	/***
	 * Type of uploaded media.<p>
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUrl() {
		return url;
	}
	
	/***
	 * Wrapped URL for the media link. This corresponds with the URL embedded directly into<p>
	 * the raw Tweet text, and the values for the indices parameter.<p>
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
