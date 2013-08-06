package com.zutil.kualy.models;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListActivities {

	private ArrayList<Activity> feed;

	public ArrayList<Activity> getFeed() {
		return feed;
	}

	public void setFeed(ArrayList<Activity> feed) {
		this.feed = feed;
	}

}
