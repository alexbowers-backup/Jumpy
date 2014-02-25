package com.bowers.alex.jumpy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class SplashScreen extends Activity {
    View     SplashScreenView;
    TextView title;
    TextView version;
    TextView created_by;
    RelativeLayout MainMenu;


    final AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
    final AlphaAnimation fadeInLate = new AlphaAnimation(0.0f, 1.0f);
    final AlphaAnimation fadeInMenu = new AlphaAnimation(0.0f, 1.0f);
    final AnimationSet titleAnimations = new AnimationSet(false);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFlags();
        setContentView(R.layout.activity_splash_screen);

        title = (TextView) findViewById(R.id.AppNameSplash);
        version = (TextView) findViewById(R.id.VersionSplash);
        created_by = (TextView) findViewById(R.id.CreatedBySplash);
        SplashScreenView = findViewById(R.id.SplashScreenView);
        MainMenu = (RelativeLayout) findViewById(R.id.MainMenu);

        Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);

        fadeIn.setDuration(1000);
        fadeIn.setStartOffset(1000);
        fadeIn.setFillAfter(true);
        fadeInLate.setDuration(1000);
        fadeInLate.setStartOffset(2000);
        fadeInLate.setFillAfter(true);
        fadeInMenu.setDuration(1000);
        fadeInMenu.setStartOffset(3200);
        fadeInMenu.setFillAfter(true);

        titleAnimations.addAnimation(fadeIn);
        titleAnimations.addAnimation(translate);
        title.startAnimation(titleAnimations);

        version.setAnimation(fadeInLate);
        created_by.setAnimation(fadeInLate);
        MainMenu.setAnimation(fadeInMenu);
    }

    @Override
    public void onResume() {
        super.onResume();
        setFlags();
    }
    public void onDestroy() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private void setFlags() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                      | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                      | View.SYSTEM_UI_FLAG_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                      | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                      | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;



        decorView.setSystemUiVisibility(uiOptions);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        decorView.requestLayout();
    }

    public void onClickSinglePlayer(View view) {
        setFlags();
        Intent intent = new Intent(this, SinglePlayerActivity.class);
        startActivity(intent);
    }

    public void onClickMultiPlayer(View view) {
        Toast.makeText(this, "Sorry. This action is not available yet.", Toast.LENGTH_LONG).show();
    }

    public void onClickLeaderboard(View view) {
        Toast.makeText(this, "Sorry. This action is not available yet.", Toast.LENGTH_LONG).show();
    }

    public void onClickAchievements(View view) {
        Toast.makeText(this, "Sorry. This action is not available yet.", Toast.LENGTH_LONG).show();
    }

}
