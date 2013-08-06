package com.zutil.kualy;


import org.holoeverywhere.app.Activity;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.octo.android.robospice.JacksonSpringAndroidSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.spicelist.BitmapSpiceManager;
import com.zutil.kualy.adapters.ActivityListAdapter;
import com.zutil.kualy.models.ListActivities;
import com.zutil.kualy.network.ActivityJsonRequest;

public class Index extends Activity {

	private static final String TAG = "Index";

	private ListView activityListView;
	private View loadingView;

	private ActivityListAdapter activityListAdapter;

	private SpiceManager spiceManagerJson = new SpiceManager(JacksonSpringAndroidSpiceService.class);
	private BitmapSpiceManager spiceManagerBinary = new BitmapSpiceManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setProgressBarIndeterminateVisibility(false);
		setContentView(R.layout.activity_index);

		// Create action bar
	    ActionBar bar = getSupportActionBar();
	    bar.setDisplayShowTitleEnabled(false);
	    bar.setIcon(R.drawable.ic_action_bar_logo);
	    BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.action_bar_background_yellow));
	    background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
	    bar.setBackgroundDrawable(background);

	    activityListView = (ListView) findViewById(R.id.actions_feed_listview);
	    loadingView = findViewById(R.id.loading_layout);
	}

	@Override
	public void onStart() {
		super.onStart();
		spiceManagerJson.start(this);
		spiceManagerBinary.start(this);

		loadListActivities();
	}

	@Override
	public void onStop() {
		spiceManagerJson.shouldStop();
		spiceManagerBinary.shouldStop();
		super.onStop();
	}

	private void updateListViewContent(ListActivities activities) {
		activityListAdapter = new ActivityListAdapter(this, spiceManagerBinary, activities);
		activityListView.setAdapter(activityListAdapter);

		loadingView.setVisibility(View.GONE);
		activityListView.setVisibility(View.VISIBLE);
	}

	private void loadListActivities() {
		setProgressBarIndeterminateVisibility(true);
		spiceManagerJson.execute(new ActivityJsonRequest("1"), "activities", DurationInMillis.ONE_SECOND * 10, new ListActivitiesListener());
	}

	private class ListActivitiesListener implements RequestListener<ListActivities> {

		@Override
		public void onRequestFailure(SpiceException spiceException) {
			setProgressBarIndeterminateVisibility(false);
			Toast.makeText(Index.this, "Imposible obtener la lista de actividades", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onRequestSuccess(ListActivities result) {
			setProgressBarIndeterminateVisibility(false);
			String serializedResult = "";
			for (com.zutil.kualy.models.Activity activity: result.getFeed()) {
				serializedResult += activity.getId() + ": " + activity.getMediaURL()+ ", ";
			}
			Log.d(TAG, serializedResult);
			updateListViewContent(result);
		}
	}
}
