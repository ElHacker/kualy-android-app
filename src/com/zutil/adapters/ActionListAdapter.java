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
import android.widget.TextView;

import com.zutil.kualy.R;
import com.zutil.lib.ActionListElement;
import com.zutil.lib.BaseListElement;
import com.zutil.lib.ImageHelper;

/**
 * Represents an adapter for actions
 * @author Zutil - Rogelio Guzman, Edilberto Ruvalcaba, Braulio Ch�vez
 *
 */
public class ActionListAdapter extends ArrayAdapter<ActionListElement>{
	
	/* For debugging */
	protected static final String TAG = "ArrayAdapter";
	/* Elements of the list */
	private List<ActionListElement> listElements;
	/* Layout id*/
	private int layoutId;
	
	/**
	 * Main constructor
	 * @param context
	 * @param resourceId
	 * @param listElements
	 * @param layoutId
	 */
	public ActionListAdapter(Context context, int resourceId,
			List<ActionListElement> listElements, int layoutId) {
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

        ActionListElement listElement = listElements.get(position);
        if (listElement != null) {
            view.setOnClickListener(listElement.getOnClickListener());
            ImageView cover_image = (ImageView) view.findViewById(R.id.cover_image);
            TextView userName = (TextView) view.findViewById(R.id.user_name);
            TextView userAction = (TextView) view.findViewById(R.id.user_action);
            if (cover_image != null) {
            	// Load the image from a url
            }
            if (userName != null) {
                userName.setText(listElement.getUserName());
            }
            if (userAction != null) {
                userAction.setText(listElement.getUserAction());
            }
            
    		// Fill the profile picture
    		ImageView profilePic = (ImageView) view.findViewById(R.id.profile_image);
    		// Get the circled bitmap
    		Bitmap circleBitmap = ImageHelper.getCircledBitmap(view.getResources(), 45);
    		// set the image
    		profilePic.setImageBitmap(circleBitmap);
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