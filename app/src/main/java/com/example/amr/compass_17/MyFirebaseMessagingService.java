package com.example.amr.compass_17;

/**
 * Created by Lenovo on 11/20/2016.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.amr.compass_17.data.ControlRealm;
import com.example.amr.compass_17.data.OneMessage;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by NgocTri on 8/9/2016.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    ControlRealm controlRealm;
    OneMessage oneMessage;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "FROM:" + remoteMessage.getFrom());


        //Check if the message contains data
        if(remoteMessage.getData().size() > 0) {
            Log.v(TAG, "Message data: " + remoteMessage.getData());
        }

        //Check if the message contains notification

//        if(remoteMessage.getNotification() != null) {
//
//            Log.d(TAG, "Mesage body:" + remoteMessage.getNotification().getBody());
//            sendNotification(remoteMessage.getNotification().getBody());
//
//        }


        Log.d(TAG, "Mesage body:" + remoteMessage.getNotification().getBody());
        sendNotification(remoteMessage.getNotification().getBody());

    }

    private void sendNotification(String body) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("body",body);
        controlRealm = new ControlRealm(this);
        oneMessage = new OneMessage(body);
        controlRealm.putMessage(oneMessage);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0/*Request code*/, intent, PendingIntent.FLAG_ONE_SHOT);
        //Set sound of notification
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifiBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Compass")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notificationSound)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /*ID of notification*/, notifiBuilder.build());
    }
}

