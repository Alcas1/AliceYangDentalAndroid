package com.bim.dentistaliceyang;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class OfficeHours extends Activity{
	MediaPlayer Ding;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setContentView(R.layout.hours);
		Ding=MediaPlayer.create(OfficeHours.this, R.raw.ding);
		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.app_icon);

		View eSendEmail = findViewById(R.id.goBack);
		eSendEmail.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				goBack();
			}
		});
	}
	private void goBack()
	{
		Intent start=new Intent("android.intent.action.start");
		Ding.start();
		startActivity(start);
	}


}
