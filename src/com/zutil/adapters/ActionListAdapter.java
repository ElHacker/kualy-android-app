package com.zutil.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zutil.kualy.R;
import com.zutil.lib.BaseListElement;
import com.zutil.lib.ImageHelper;

/**
 * Represents an adapter for actions
 * @author Zutil - Rogelio Guzman, Edilberto Ruvalcaba, Braulio Ch�vez
 *
 */
public class ActionListAdapter extends ArrayAdapter<BaseListElement>{
	
	/* For debugging */
	protected static final String TAG = "ArrayAdapter";
	/* Elements of the list */
	private List<BaseListElement> listElements;
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
			List<BaseListElement> listElements, int layoutId) {
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

        BaseListElement listElement = listElements.get(position);
        if (listElement != null) {
            view.setOnClickListener(listElement.getOnClickListener());
            ImageView cover_image = (ImageView) view.findViewById(R.id.cover_image);
            TextView tex1 = (TextView) view.findViewById(R.id.user_name);
            TextView text2 = (TextView) view.findViewById(R.id.user_action);
            TextView text3 = (TextView) view.findViewById(R.id.karma_text);
            if (cover_image != null) {
            	// Load the image from a url
            }
            if (tex1 != null) {
                tex1.setText(listElement.getText1());
            }
            if (text2 != null) {
                text2.setText(listElement.getText2());
            }
            if (text3 != null) {
            	text3.setText(listElement.getText3());
            }
            
    		// Fill the profile picture
    		ImageView profilePic = (ImageView) view.findViewById(R.id.profile_image);
    		// Get the circled bitmap
    		Bitmap circleBitmap = ImageHelper.getCircledBitmap(view.getResources(), 50);
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