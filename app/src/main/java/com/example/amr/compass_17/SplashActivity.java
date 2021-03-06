package com.example.amr.compass_17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.amr.compass_17.data.Users;

public class SplashActivity extends AppCompatActivity {
    Users data;
    ImageView logo,main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo=(ImageView)findViewById(R.id.img_logo);
        main=(ImageView)findViewById(R.id.maain);
        data = new Users(getApplicationContext());
        Animation fadeee = AnimationUtils.loadAnimation(this,R.anim.faade);
        Animation mAnim= AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        logo.startAnimation(fadeee);
        main.startAnimation(mAnim);
        mAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                finish();
                Intent intent;
                if (data.getLogin())
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                else
                    intent = new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}

