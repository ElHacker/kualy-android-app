package com.zutil.kualy;

import java.util.ArrayList;
import java.util.List;

import org.holoeverywhere.app.Activity;
import org.holoeverywhere.widget.ListView;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.ActionBar;
import com.zutil.adapters.ChallengeListAdapter;
import com.zutil.lib.BaseListElement;
import com.zutil.lib.ChallengeListElement;

public class Challenges extends Activity {
	
	private static final String TAG = "Challenges";
	
	private ListView listView;
	
	private List<ChallengeListElement> listElements;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_challenges);
		
		// Create action bar
	    ActionBar bar = getSupportActionBar();
	    bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	    bar.setDisplayShowTitleEnabled(true);
	    bar.setTitle("Retos");
	    BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.action_bar_background));
	    background.setTileModeX(android.graphics.Shader.TileMode.REPEAT); 
	    bar.setBackgroundDrawable(background);
		
		listView = (ListView) findViewById(android.R.id.list);
		// Set the listview header
		LayoutInflater inflater = getLayoutInflater();
		View header = inflater.inflate(R.layout.challenge_list_header, (ViewGroup) findViewById(R.id.challenge_header_layout_root));
		listView.addHeaderView(header);
		
		// Set up the list view items, based on a list of
	 	// BaseListElement items
	 	listElements = new ArrayList<ChallengeListElement>();
	 	
	 	int colors[] = { R.color.orange_palette, R.color.purple, R.color.blue, R.color.green_palette};
	 	for(int i = 0; i < 9; i++) {
	 		ChallengeListElement event = new ChallengeListElement(this, "" + (i + 1), "Ayuda a un extraño", "Humanidad", "12 Logros", colors[i%4]);
	 		listElements.add(event);
	 	}
	 	
	 	listView.setAdapter(new ChallengeListAdapter(this, android.R.id.list, listElements, R.layout.challenge_list_element));
		
	}

}
