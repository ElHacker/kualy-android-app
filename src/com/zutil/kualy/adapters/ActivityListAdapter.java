package com.zutil.kualy.adapters;

import java.io.File;

import android.content.Context;
import android.view.ViewGroup;

import com.octo.android.robospice.request.simple.BitmapRequest;
import com.octo.android.robospice.spicelist.BitmapSpiceManager;
import com.octo.android.robospice.spicelist.SpiceArrayAdapter;
import com.octo.android.robospice.spicelist.SpiceListItemView;
import com.zutil.kualy.models.Activity;
import com.zutil.kualy.models.ListActivities;
import com.zutil.kualy.views.ActivityView;

public class ActivityListAdapter extends SpiceArrayAdapter<Activity>{

	public ActivityListAdapter(Context context, BitmapSpiceManager spiceManagerBitmap, ListActivities activities) {
		super(context, spiceManagerBitmap, activities.getFeed());
	}

	@Override
	public BitmapRequest createRequest(Activity activity, int imageIndex, int requestImageWidth, int requestImageHeight) {
		File tempFile = new File(getContext().getCacheDir(), "THUMB_IMAGE_TMP_" + activity.getId());
		return new BitmapRequest(activity.getMediaURL(), tempFile);
	}

	@Override
	public SpiceListItemView<Activity> createView(Context context, ViewGroup parent) {
		return new ActivityView(getContext());
	}

}
