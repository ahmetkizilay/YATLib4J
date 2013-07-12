package com.ahmetkizilay.yatlib4j.datatypes;

public class Sizes {
	private Size thumb;
	private Size large;
	private Size medium;
	private Size small;
	
	public Size getThumb() {
		return thumb;
	}
	
	/***
	 * Information for a thumbnail-sized version of the media.<p>
	 * 
	 * @param thumb
	 */
	public void setThumb(Size thumb) {
		this.thumb = thumb;
	}
	
	public Size getLarge() {
		return large;
	}
	
	/***
	 * Information for a large-sized version of the media.<p>
	 * 
	 * @param large
	 */
	public void setLarge(Size large) {
		this.large = large;
	}
	
	public Size getMedium() {
		return medium;
	}
	
	/***
	 * Information for a medium-sized version of the media.<p>
	 * 
	 * @param medium
	 */
	public void setMedium(Size medium) {
		this.medium = medium;
	}
	
	public Size getSmall() {
		return small;
	}
	
	/***
	 * Information for a small-sized version of the media.<p>
	 * 
	 * @param small
	 */
	public void setSmall(Size small) {
		this.small = small;
	}
	
	
}
