package com.zutil.lib;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.zutil.kualy.Challenge;

/**
 * Represents an element of the challenges list
 *
 */
public class ChallengeListElement extends BaseListElement {
	
	private final String TAG = "EventListElement";
	
	private Context context;
	private String challengeNumber;
	private String challengeName;
	private String challengeArea;
	private String challengeAccomplished;
	private int challengeColor;

	/**
	 * Main Constructor for an element
	 * @param user_name
	 * @param user_action
	 * @param coverImageResource
	 */
    public ChallengeListElement( Context context, String challengeNumber, String challengeName, String challengeArea, String challengeAccomplished, int challengeColor) {
        super();
        this.challengeNumber = challengeNumber;
        this.challengeName = challengeName;
        this.challengeArea = challengeArea;
        this.challengeAccomplished = challengeAccomplished;
        this.challengeColor = challengeColor;
        this.context = context;
    }
    
    public String getChallengeNumber() {
		return challengeNumber;
	}

	public void setChallengeNumber(String challengeNumber) {
		this.challengeNumber = challengeNumber;
	}

	public String getChallengeName() {
		return challengeName;
	}

	public void setChallengeName(String challengeName) {
		this.challengeName = challengeName;
	}

	public String getChallengeArea() {
		return challengeArea;
	}

	public void setChallengeArea(String challengeArea) {
		this.challengeArea = challengeArea;
	}

	public String getChallengeAccomplished() {
		return challengeAccomplished;
	}

	public void setChallengeAccomplished(String challengeAccomplished) {
		this.challengeAccomplished = challengeAccomplished;
	}
	
	public int getChallengeColor() {
		return challengeColor;
	}

	public void setChallengeColor(int challengeColor) {
		this.challengeColor = challengeColor;
	}

	@Override
    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	// Call challenge activity
				Intent intent = new Intent(context, Challenge.class );
				context.startActivity(intent);
            }
        };
    }
}