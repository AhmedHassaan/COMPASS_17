package com.example.amr.compass_17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.amr.compass_17.data.Users;

public class SplashActivity extends AppCompatActivity {
    protected static final int TIMER_RUNTIME = 5000;
    protected boolean mbActive;
    protected ProgressBar progressBar;
    Users data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        data = new Users (getApplicationContext());
        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            System.exit(0);
            return; // add this to prevent from doing unnecessary stuffs
        }
        progressBar = (ProgressBar) findViewById(R.id.bb);

        final Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                mbActive = true;
                try {
                    int waited=0;
                    while (mbActive && (waited<TIMER_RUNTIME))
                    {
                        Thread.sleep(100);
                        if (mbActive)
                        {
                            waited +=100;
                            updatePro(waited);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    oncontinue();
                    Intent intent;
                    if(data.getLogin())
                        intent = new Intent(SplashActivity.this , MainActivity.class);
                    else
                        intent = new Intent(SplashActivity.this , LogInActivity.class);

                    startActivity(intent);
                }
            }
        });
        timerThread.start();
    }
    public void updatePro (final int timepassed) {
        if (null != progressBar){
            final int progress = progressBar.getMax() * timepassed / TIMER_RUNTIME ;
            progressBar.setProgress(progress);
        }
    }
    public void oncontinue (){
        Log.d("mensagemFinal","Sua barra de loading acabou de Carregar!!!");
    }
}

