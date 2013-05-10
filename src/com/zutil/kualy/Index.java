package com.zutil.kualy;


import org.holoeverywhere.app.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.zutil.lib.ImageHelper;

public class Index extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		
		// Create action bar
	    ActionBar bar = getSupportActionBar();
	    bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	    bar.setDisplayShowTitleEnabled(true);
	    bar.setTitle("Kualy");
	    BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.action_bar_background));
	    background.setTileModeX(android.graphics.Shader.TileMode.REPEAT); 
	    bar.setBackgroundDrawable(background);
		
		// Fill the profile picture
		ImageView profilePic = (ImageView) findViewById(R.id.profile_image);
		// Get the circled bitmap
		Bitmap circleBitmap = ImageHelper.getCircledBitmap(getResources(), 50);
		// set the image
		profilePic.setImageBitmap(circleBitmap);
	}


}
