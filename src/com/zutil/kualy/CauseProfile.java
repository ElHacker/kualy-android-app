package com.zutil.kualy;

import org.holoeverywhere.app.Activity;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;

public class CauseProfile extends Activity {

	private static final String TAG = "CauseProfile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cause);

		// Create action bar
	    ActionBar bar = getSupportActionBar();
	    bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	    bar.setDisplayShowTitleEnabled(false);
	    bar.setIcon(R.drawable.ic_action_bar_logo);
	    BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.action_bar_background_yellow));
	    background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
	    bar.setBackgroundDrawable(background);

	}
}
