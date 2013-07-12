package com.ahmetkizilay.yatlib4j.datatypes;

public class Size {
	private int h;
	private String resize;
	private int w;
	
	public int getH() {
		return h;
	}
	
	/***
	 * Height in pixels of this size.<p>
	 * 
	 * @param h
	 */
	public void setH(int h) {
		this.h = h;
	}
	
	public String getResize() {
		return resize;
	}
	
	/***
	 * Resizing method used to obtain this size. A value of fit<p>
	 * means that the media was resized to fit one dimension, keeping its<p>
	 * native aspect ratio. A value of crop means that the media was cropped<p>
	 * in order to fit a specific resolution.<p>
	 * 
	 * @param resize
	 */
	public void setResize(String resize) {
		this.resize = resize;
	}
	
	public int getW() {
		return w;
	}
	
	/***
	 * Width in pixels of this size.<p>
	 * @param w
	 */
	public void setW(int w) {
		this.w = w;
	}
	
	
}
