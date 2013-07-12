package com.ahmetkizilay.yatlib4j.datatypes;

import java.util.ArrayList;

public class Entities {
	private ArrayList<Hashtag> hashtags;
	private ArrayList<Media> media;
	private ArrayList<URL> urls;
	private ArrayList<UserMention> userMentions;
	
	public ArrayList<Hashtag> getHashtags() {
		return hashtags;
	}
	
	/***
	 * Represents hashtags which have been parsed out of the Tweet text.<p>
	 * 
	 * @param hashtags
	 */
	public void setHashtags(ArrayList<Hashtag> hashtags) {
		this.hashtags = hashtags;
	}
	
	public ArrayList<Media> getMedia() {
		return media;
	}
	
	/***
	 * Represents media elements uploaded with the Tweet.<p>
	 * 
	 * @param media
	 */
	public void setMedia(ArrayList<Media> media) {
		this.media = media;
	}
	
	public ArrayList<URL> getUrls() {
		return urls;
	}
	
	/***
	 * Represents URLs included in the text of a Tweet or within textual fields of a user object.<p>
	 * 
	 * @param urls
	 */
	public void setUrls(ArrayList<URL> urls) {
		this.urls = urls;
	}
	
	public ArrayList<UserMention> getUserMentions() {
		return userMentions;
	}
	
	/***
	 * Represents other Twitter users mentioned in the text of the Tweet.<p>
	 *	
	 * @param userMentions
	 */
	public void setUserMentions(ArrayList<UserMention> userMentions) {
		this.userMentions = userMentions;
	}
}
