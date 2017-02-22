package com.example.amr.compass_17;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.amr.compass_17.data.Users;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Lenovo on 1/1/2017.
 */

public class NotificationServices extends Service {
    Users data;
    DatabaseReference db;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        data = new Users(getBaseContext());
        db= FirebaseDatabase.getInstance().getReference();
        Intent intent = new Intent(getBaseContext(),SplashActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        final NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        final String workshop = data.getWorkshop();
        DatabaseReference db1 = db.child("Message").child(workshop);
        db1.limitToLast(1).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String lastMess = data.getLastMessage();
                String msg = dataSnapshot.getValue(String.class);
                Log.i("BG",msg);
                Log.i("BG",lastMess);
                if(lastMess.equals(msg)){
                    Log.i("BG","If condition");

                }
                else {
                    Log.i("BG","else condition");
                    data.setLastMessage(msg);
                    NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext());
                    notification.setContentIntent(pendingIntent)
                            .setAutoCancel(true)
                            .setSmallIcon(R.drawable.compass)
                            .setContentTitle(workshop)
                            .setContentText(dataSnapshot.getValue(String.class))
                            .setOnlyAlertOnce(true);
                    notificationManager.notify(0, notification.build());
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_STICKY;

    }
}
