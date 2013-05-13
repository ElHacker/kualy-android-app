package com.zutil.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zutil.kualy.R;
import com.zutil.lib.ChallengeListElement;
import com.zutil.lib.ImageHelper;

/**
 * Represents an adapter for challenges
 *
 */
public class ChallengeListAdapter extends ArrayAdapter<ChallengeListElement>{
	
	/* For debugging */
	protected static final String TAG = "ArrayAdapter";
	/* Elements of the list */
	private List<ChallengeListElement> listElements;
	/* Layout id*/
	private int layoutId;
	
	/**
	 * Main constructor
	 * @param context
	 * @param resourceId
	 * @param listElements
	 * @param layoutId
	 */
	public ChallengeListAdapter(Context context, int resourceId,
			List<ChallengeListElement> listElements, int layoutId) {
		super(context, resourceId, listElements);
		this.listElements = listElements;
		this.layoutId = layoutId;
		// Set up as an observer for list item changes to
		// refresh the view
		for (int i = 0; i < listElements.size(); i++) {
			listElements.get(i).setAdapter(this);
		}
	}
	
	/**
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 * Renders the view of the elements inside a list
	 */
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.layoutId, null);
        }

        ChallengeListElement listElement = listElements.get(position);
        if (listElement != null) {
            view.setOnClickListener(listElement.getOnClickListener());
            LinearLayout challengeLayout = (LinearLayout) view.findViewById(R.id.challenge_layout);
            TextView challengeNumber = (TextView) view.findViewById(R.id.challenge_number);
            TextView challengeName = (TextView) view.findViewById(R.id.challenge_name);
            TextView challengeArea = (TextView) view.findViewById(R.id.challenge_area);
            TextView challengeAccomplished = (TextView) view.findViewById(R.id.challenge_accomplished);
            if(challengeLayout != null) {
            	// Change background color
            	challengeLayout.setBackgroundResource(listElement.getChallengeColor());
            } 
            if (challengeNumber != null) {
                challengeNumber.setText(listElement.getChallengeNumber());
            }
            if (challengeName != null) {
                challengeName.setText(listElement.getChallengeName());
            }
            if (challengeArea != null) {
            	challengeArea.setText(listElement.getChallengeArea());
            }
            if(challengeAccomplished != null) {
            	challengeAccomplished.setText(listElement.getChallengeAccomplished());
            }
            
        }
        return view;
    }

	/**
	 * Returns the activity for the context
	 * @return the activity for the context
	 */
	private Activity getActivity() {
		Activity activity = (Activity) getContext();
		return activity;
	}
	
}