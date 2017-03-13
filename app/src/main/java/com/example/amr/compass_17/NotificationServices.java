package com.example.amr.compass_17;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

import com.example.amr.compass_17.data.ControlRealm;
import com.example.amr.compass_17.data.Event;
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
    ControlRealm realm;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        data = new Users(getBaseContext());
        realm = new ControlRealm(getBaseContext());
        db = FirebaseDatabase.getInstance().getReference();
        Intent intent = new Intent(getBaseContext(), SplashActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, 0);
        final NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        final String workshop = data.getWorkshop();
        if (data.getLogin()) {
            DatabaseReference workshopref = db.child("Workshop").child("nougat");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    switch (dataSnapshot.getKey()) {
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class), "nougat");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class), "nougat");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class), "nougat");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("triple");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    switch (dataSnapshot.getKey()) {
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class), "triple");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class), "triple");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class), "triple");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("topaz");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    switch (dataSnapshot.getKey()) {
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class), "topaz");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class), "topaz");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class), "topaz");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("smiley");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    switch (dataSnapshot.getKey()) {
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class), "smiley");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class), "smiley");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class), "smiley");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("photoshop");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    switch (dataSnapshot.getKey()) {
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class), "photoshop");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class), "photoshop");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class), "photoshop");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("ulalia");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    switch (dataSnapshot.getKey()) {
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class), "ulalia");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class), "ulalia");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class), "ulalia");
                            break;
                        default:
                            break;
                    }
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


            DatabaseReference db1 = db.child("Message").child(workshop);
            db1.limitToLast(1).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String lastMess = data.getLastMessage();
                    String msg = dataSnapshot.getValue(String.class);
                    if (!lastMess.equals(msg)) {
                        data.setLastMessage(msg);
                        realm.setMessage(dataSnapshot.getValue(String.class),workshop);
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
        if(data.getEventNotificationActivate()) {
            DatabaseReference db1 = db.child("events");
            db1.limitToLast(1).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String lastevent = data.getLastEvent();
                    String eve = dataSnapshot.getValue(String.class);
                    if (!lastevent.equals(eve)) {
                        data.setLastEvent(eve);
                        String[] ss = eve.split("---");
                        Event event = new Event();
                        event.setName(ss[0]);
                        event.setLocation(ss[1]);
                        event.setDescription(ss[2]);
                        event.setImage(ss[3]);
                        event.setTime(ss[4]);
                        realm.putEvent(event);
                        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext());
                        notification.setContentIntent(pendingIntent)
                                .setAutoCancel(true)
                                .setSmallIcon(R.drawable.compass)
                                .setContentTitle(ss[0])
                                .setContentText(ss[2])
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
        else{
            data.setEventNotificationActivate();
        }

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_STICKY;

    }
}
