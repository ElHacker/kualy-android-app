package com.zutil.kualy;

import org.holoeverywhere.app.Activity;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;

public class Challenge extends Activity {

	private static final String TAG = "Challenge";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_challenge);

		// Create action bar
	    ActionBar bar = getSupportActionBar();
	    bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	    bar.setDisplayShowTitleEnabled(true);
	    bar.setTitle("Reto");
	    BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.action_bar_background_yellow));
	    background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
	    bar.setBackgroundDrawable(background);

	}

}
