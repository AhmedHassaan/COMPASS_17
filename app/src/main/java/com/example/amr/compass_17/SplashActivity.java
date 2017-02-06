package com.example.amr.compass_17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.amr.compass_17.data.Users;

public class SplashActivity extends AppCompatActivity {
    Users data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(getIntent().getExtras()!=null) {
            Bundle b = getIntent().getExtras();
            String s = b.getString("p");
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }
        data = new Users(getApplicationContext());
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent;
                    if (data.getLogin())
                        intent = new Intent(SplashActivity.this, MainActivity.class);
                    else
                        intent = new Intent(SplashActivity.this, LogInActivity.class);

                    startActivity(intent);
                    SplashActivity.this.finish();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}

