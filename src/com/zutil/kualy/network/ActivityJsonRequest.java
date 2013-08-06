package com.zutil.kualy.network;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import com.zutil.kualy.models.ListActivities;

public class ActivityJsonRequest extends SpringAndroidSpiceRequest<ListActivities>{

	private String baseUrl = "http://192.168.0.102:1337/users/%s/feed";
	private String userId;

	public ActivityJsonRequest(String userId) {
		super(ListActivities.class);
		this.userId = userId;
	}

	@Override
	public ListActivities loadDataFromNetwork() throws Exception {
		String url = String.format(baseUrl, userId);
		return getRestTemplate().getForObject(url, ListActivities.class);
	}
}
