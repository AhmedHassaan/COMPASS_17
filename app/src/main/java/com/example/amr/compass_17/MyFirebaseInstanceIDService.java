package com.example.amr.compass_17;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Lenovo on 11/20/2016.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String REG_TOKEN = "REG_TOKEN";

    @Override
    public void onTokenRefresh() {
        //Get updated token
        String recent_Token = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recent_Token);

        //You can save the token into third party server to do anything you want
    }

}
