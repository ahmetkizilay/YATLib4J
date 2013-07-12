package com.ahmetkizilay.yatlib4j.datatypes;

public class Hashtag {
	private int[] indices;
	private String text;
	
	public int[] getIndices() {
		return indices;
	}
	
	/***
	 * An array of integers indicating the offsets within the Tweet text where <p>
	 * the hashtag begins and ends. The first integer represents the location of the <p>
	 * # character in the Tweet text string. The second integer represents the location <p>
	 * of the first character after the hashtag. Therefore the difference between <p>
	 * the two numbers will be the length of the hashtag name plus one (for the '#' character). <p>
	 * 
	 * @param indices
	 */
	public void setIndices(int[] indices) {
		this.indices = indices;
	}
	
	public String getText() {
		return text;
	}
	
	/***
	 * Name of the hashtag, minus the leading '#' character.<p>
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
}
