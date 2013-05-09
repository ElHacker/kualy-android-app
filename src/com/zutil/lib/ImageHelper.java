package com.zutil.lib;

import com.zutil.kualy.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;

public class ImageHelper {
	
	/**
	 * Method to scale and reshape an image to a circle.
	 * @param resources
	 * @param diameter	the diameter of the circle
	 * @return circleBitmap the circled and scaled bitmap image
	 */
	public static Bitmap getCircledBitmap(Resources resources, int diameter) {
		int width = diameter;
		int height = diameter;
		
		// Get the bitmap
		Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.profile);
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
		Bitmap circleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		// Use a shader
		BitmapShader shader = new BitmapShader(scaledBitmap, TileMode.CLAMP, TileMode.CLAMP);
		Paint paint = new Paint();
		paint.setShader(shader);
		paint.setAntiAlias(true);
		// Draw the canvas
		Canvas c = new Canvas(circleBitmap);
		c.drawCircle(width/2, height/2, width/2, paint);
		return circleBitmap;
	}
}
