package com.ahmetkizilay.yatlib4j.datatypes;

public class URL {
	private String displayUrl;
	private String expandedUrl;
	private int[] indices;
	private String url;
	
	public String getDisplayUrl() {
		return displayUrl;
	}
	
	/***
	 * Version of the URL to display to clients.<p>
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
	 * Expanded version of display_url.<p>
	 * 
	 * @param expandedUrl
	 */
	public void setExpandedUrl(String expandedUrl) {
		this.expandedUrl = expandedUrl;
	}
	
	public int[] getIndices() {
		return indices;
	}
	
	/***
	 * An array of integers representing offsets within the Tweet text<p>
	 * where the URL begins and ends. The first integer represents the location<p>
	 * of the first character of the URL in the Tweet text. The second integer<p>
	 * represents the location of the first non-URL character after the end of the URL.<p>
	 * 
	 * @param indices
	 */
	public void setIndices(int[] indices) {
		this.indices = indices;
	}
	
	public String getUrl() {
		return url;
	}
	
	/***
	 * Wrapped URL, corresponding to the value embedded directly into the raw Tweet text,<p>
	 * and the values for the <code>indices</code> parameter.<p>
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
