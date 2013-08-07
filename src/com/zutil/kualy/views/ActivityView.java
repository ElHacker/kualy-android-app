package com.zutil.kualy.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.octo.android.robospice.spicelist.SpiceListItemView;
import com.zutil.kualy.R;
import com.zutil.kualy.models.Activity;

public class ActivityView extends LinearLayout implements SpiceListItemView<Activity>{

	private ImageView activityImageView;
	private TextView activityBodyTextView;
	private Activity activity;

	public ActivityView(Context context) {
		super(context);
		inflateView(context);
	}

	private void inflateView(Context context) {
		LayoutInflater.from(context).inflate(R.layout.action_list_item, this);
		this.activityImageView = (ImageView) this.findViewById(R.id.activity_image);
		this.activityBodyTextView = (TextView) this.findViewById(R.id.activity_body);
	}

	@Override
	public void update(Activity activity) {
		this.activity = activity;
		this.activityBodyTextView.setText(activity.getBody());
	}

	@Override
	public Activity getData() {
		return activity;
	}

	@Override
	public ImageView getImageView(int imageIndex) {
		return activityImageView;
	}

	@Override
	public int getImageViewCount() {
		return 1;
	}
}