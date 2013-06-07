package com.bim.dentistaliceyang;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class Email extends Activity{
	EditText subject,name,message;
	String subjectAdd,nameAdd,messageAdd;
	MediaPlayer Ding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setContentView(R.layout.email);
		Ding=MediaPlayer.create(Email.this, R.raw.ding);
		init();
		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.app_icon);

		View eSendEmail = findViewById(R.id.sendEmail);
		eSendEmail.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				sendEmail();
			}
		});
	}

	private void init()
	{
		subject=(EditText) findViewById(R.id.subject);
		name=(EditText) findViewById(R.id.name);
		message=(EditText) findViewById(R.id.message);
	}

	private void editTextToStrings()
	{
		subjectAdd=subject.getText().toString();
		nameAdd=name.getText().toString();
		messageAdd=message.getText().toString();
	}

	private void sendEmail() {
		editTextToStrings();
		Ding.start();
		String emailrecieve[]={"Aliceyangdental@gmail.com"};
		String body="Name:"
				+nameAdd
				+'\n'
				+'\n'
				+"Message:"
				+messageAdd+
				'\n'+
				'\n'+
				'\n'+
				Setting.EMAIL_OUTRO;
		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
		intent.putExtra(android.content.Intent.EXTRA_EMAIL,emailrecieve);
		intent.putExtra(android.content.Intent.EXTRA_SUBJECT,subjectAdd);
		intent.setType("plain/text");
		intent.putExtra(android.content.Intent.EXTRA_TEXT,body);
		//Aliceyangdental@gmail.com
		startActivity(intent);
	}
}
