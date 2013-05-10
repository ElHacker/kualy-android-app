package com.zutil.lib;

import android.view.View;
import android.widget.BaseAdapter;

/**
 * Represents a base element from a list
 *
 */
public abstract class BaseListElement {
	
	/* Attribute for the element on list */
	private String text1;
	/* Attribute for the element on list */
	private String text2;
	/* Attribute for the element on list */
	private String text3;
	/* Attribute for the element on list */
	private String imageResourceURL;
	/* Attribute for the element on list */
	private BaseAdapter adapter;

	/**
	 * Main Constructor
	 * @param text1
	 * @param text2
	 * @param imageResourceURL
	 */
	public BaseListElement(String text1, String text2, String text3, String imageResourceURL) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.imageResourceURL = imageResourceURL;
	}
	
	/**
	 * Sets the adapter
	 * @param adapter
	 */
	public void setAdapter(BaseAdapter adapter) {
	    this.adapter = adapter;
	}

	/**
	 * Gets the first text
	 * @return a string
	 */
	public String getText1() {
		return text1;
	}
	
	
	/**
	 * Sets a text
	 * @param text1
	 */
	public void setText1(String text1) {
		this.text1 = text1;
		if (adapter != null) {
		    adapter.notifyDataSetChanged();
		}
	}
	
	
	/**	
	 * Gets a text
	 * @return a string text
	 */
	public String getText2() {
		return text2;
	}
	
	/**
	 * Sets a text
	 * @param text2
	 */
	public void setText2(String text2) {
		this.text2 = text2;
		if (adapter != null) {
		    adapter.notifyDataSetChanged();
		}
	}
	
	
	public String getText3() {
		return text3;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

	/**
	 * Gets the image id 
	 * @return string url
	 */
	public String getImageResourceURL() {
		return imageResourceURL;
	}

	/**
	 * Sets the id for the image
	 * @param imageResourceURL
	 */
	public void setImageResource(String imageResourceURL) {
		this.imageResourceURL = imageResourceURL;
	}

	public abstract View.OnClickListener getOnClickListener();
	
}
