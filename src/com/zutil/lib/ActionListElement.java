package com.zutil.lib;

import android.content.Context;
import android.view.View;

/**
 * Represents an element of the events list, picture
 * name, and a brief description
 *
 */
public class ActionListElement extends BaseListElement {
	
	private final String TAG = "EventListElement";
	
	private Context context;
	private String userName;
	private String userAction;
	private String karmaPoints;
	private String coverImageResource;

	/**
	 * Main Constructor for an element
	 * @param userName
	 * @param userAction
	 * @param coverImageResource
	 */
    public ActionListElement(Context context, String userName, String userAction, String karmaPoints, String coverImageResource) {
        super();
        this.userName = userName;
        this.userAction = userAction;
        this.karmaPoints = karmaPoints;
        this.coverImageResource = coverImageResource;
        this.context = context;
    }
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public String getKarmaPoints() {
		return karmaPoints;
	}

	public void setKarmaPoints(String karmaPoints) {
		this.karmaPoints = karmaPoints;
	}

	public String getCoverImageResource() {
		return coverImageResource;
	}

	public void setCoverImageResource(String coverImageResource) {
		this.coverImageResource = coverImageResource;
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