package com.zutil.kualy;

import com.zutil.lib.ImageHelper;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.view.Menu;
import android.widget.ImageView;

public class Index extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		ImageView profilePic = (ImageView) findViewById(R.id.profile_pic);
		// Get the circled bitmap
		Bitmap circleBitmap = ImageHelper.getCircledBitmap(getResources(), 50);
		// set the image
		profilePic.setImageBitmap(circleBitmap);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_index, menu);
		return true;
	}

}
