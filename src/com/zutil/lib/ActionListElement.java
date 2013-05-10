package com.zutil.lib;

import android.view.View;

/**
 * Represents an element of the events list, picture
 * name, and a brief description
 *
 */
public class ActionListElement extends BaseListElement {
	
	private final String TAG = "EventListElement";

	/**
	 * Main Constructor for an element
	 * @param user_name
	 * @param user_action
	 * @param coverImageResource
	 */
    public ActionListElement( String user_name, String user_action, String karma_points, String coverImageResource) {
        super(user_name, user_action, karma_points, coverImageResource);
    }

    @Override
    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	// Start event description activity
            }
        };
    }
}