package com.bim.dentistaliceyang;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class ActivityMain extends Activity {
	private static final int ACTION_ADD_EVENT = 1;
	MediaPlayer Ding;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setContentView(R.layout.main);
		Ding=MediaPlayer.create(ActivityMain.this, R.raw.ding);
		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.app_icon);

		View mAddEvent = findViewById(R.id.main_add_event_button);
		mAddEvent.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Ding.start();
				doAddEvent();
			}
		});
		
		View mOfficeHours = findViewById(R.id.main_office_hours_button);
		mOfficeHours.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Ding.start();
				doOfficeHours();
			}
		});
		/*View mEventHistory = findViewById(R.id.main_event_history_button);
		mEventHistory.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Ding.start();
				doEventHistory();
			}
		});*/
		/*View mAddReview=findViewById(R.id.main_add_review_button);
		mAddReview.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Ding.start();
				doAddReview();
			}
		});
		*/
		

		View mCall = findViewById(R.id.main_call_button);
		mCall.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Ding.start();
				doCall();
			}
		});

		View mEmail = findViewById(R.id.main_email_button);
		mEmail.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Ding.start();
				doEmail();
			}
		});

		View mMap = findViewById(R.id.main_map_button);
		mMap.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Ding.start();
				doMap();
			}
		});
	}

	private void doAddEvent() {

		Intent intent = new Intent(Intent.ACTION_EDIT);
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra("title", Setting.OFFICE_EVENT_TITLE);
		intent.putExtra("eventLocation", Setting.OFFICE_EVENT_ADDRESS);
		intent.putExtra("description", Setting.OFFICE_EVENT_DESC);
		startActivity(intent);
	}

	/*private void doEventHistory() {
		Intent intent = new Intent(Intent.ACTION_EDIT);
		startActivity(intent);

	}*/

	private void doAddReview()
	{
		
		
	}
	
	private void doOfficeHours()
	{
		Intent intent = new Intent("android.intent.action.OfficeHours");
		startActivity(intent);
	}
	
	private void doCall() {
		Uri phoneUri = Uri.fromParts("tel", Setting.OFFICE_PHONE, null);
		Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
		startActivity(intent);
	}

	private void doEmail() {

		Intent intent = new Intent("android.intent.action.Email");
		startActivity(intent);
	}

	private void doMap() {
		String t = "geo:" + Setting.OFFICE_LAT_LON + "?z=16";
		Uri mapUri = Uri.parse(t);
		startActivity(new Intent(Intent.ACTION_VIEW, mapUri));
	}

	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {

		switch (requestCode) {
		case ACTION_ADD_EVENT:

			break;
		}
	}
}