package com.zutil.kualy;


import java.util.ArrayList;
import java.util.List;

import org.holoeverywhere.app.Activity;
import org.holoeverywhere.widget.ListView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.actionbarsherlock.app.ActionBar;
import com.zutil.adapters.ActionListAdapter;
import com.zutil.lib.BaseListElement;
import com.zutil.lib.ActionListElement;
import com.zutil.lib.ImageHelper;

public class Index extends Activity {
	
	private static final String TAG = "Index";
	
	private ListView listView;
	
	private List<BaseListElement> listElements;
	
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
		
		listView = (ListView) findViewById(android.R.id.list);
		
		// Set up the list view items, based on a list of
	 	// BaseListElement items
	 	listElements = new ArrayList<BaseListElement>();
	 	
	 	for(int i = 0; i < 3; i++) {
	 		ActionListElement event = new ActionListElement("Braulio Chavez", "Ayudando a un extraño", "250", "http://foo.bar.com");
	 		listElements.add(event);
	 	}
	 	
	 	listView.setAdapter(new ActionListAdapter(this, android.R.id.list, listElements, R.layout.list_item));
		
	}


}
