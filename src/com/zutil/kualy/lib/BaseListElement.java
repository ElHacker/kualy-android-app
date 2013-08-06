package com.zutil.kualy.lib;

import android.view.View;
import android.widget.BaseAdapter;

/**
 * Represents a base element from a list
 *
 */
public abstract class BaseListElement {
	
	/* Attribute for the element on list */
	private BaseAdapter adapter;

	/**
	 * Main Constructor
	 */
	public BaseListElement() {
		super();
	}
	
	/**
	 * Sets the adapter
	 * @param adapter
	 */
	public void setAdapter(BaseAdapter adapter) {
	    this.adapter = adapter;
	}

	public abstract View.OnClickListener getOnClickListener();
	
}
