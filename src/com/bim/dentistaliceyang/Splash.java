package com.bim.dentistaliceyang;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;


public class Splash extends Activity{
	MediaPlayer Intro;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setContentView(R.layout.splash);
		Intro=MediaPlayer.create(Splash.this, R.raw.intro);
		setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.app_icon);
		Thread timer=new Thread()
		{
			public void run()
			{
				
				try{
					Intro.start();
					sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent start=new Intent("android.intent.action.start");
					startActivity(start);
				}
			}
			
		};
		timer.start();
	}
	protected void onPause()
	{
		super.onPause();
		Intro.release();
		finish();
		
	}
	
	
}
