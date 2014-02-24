package com.zando.jumpy;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	private static final int INITIAL_HIDE_DELAY = 1000;
	private GLSurfaceView mSurfaceView;
	private GLSurfaceView mGLView;
	private View view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		switch(android.os.Build.VERSION.SDK_INT) {
			case 19: // kitkat
				view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
				view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
				view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
				break;
			case 16: // JB
			case 17:
			case 18:
				view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
				view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
				break;
		}
		
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		if(hasFocus) {
			delayedHide(INITIAL_HIDE_DELAY);
		} else {
			mHideSystemUiHandler.removeMessages(0);
		}
	}
	
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
		delayedHide(INITIAL_HIDE_DELAY);
	}
	private void hideSystemUI() {

		if(android.os.Build.VERSION.SDK_INT >= 19) {
			// Kitkat
			view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE 
					 | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					 | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					 | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
					 | View.SYSTEM_UI_FLAG_FULLSCREEN
					 | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		} else if(android.os.Build.VERSION.SDK_INT >= 16) {
			
		} else if(android.os.Build.VERSION.SDK_INT >= 14) {
			
		} else {
			// Shouldn't have app.
		}
		
		
	}
	
	private void showSystemUI() {
		view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE 
				 | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				 | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
	}
	
	Handler mHideSystemUiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			hideSystemUI();
		}
	};
	
	private void delayedHide(int delayMillis) {
		mHideSystemUiHandler.removeMessages(0);
		mHideSystemUiHandler.sendEmptyMessageDelayed(0, delayMillis);
	}
	

}
