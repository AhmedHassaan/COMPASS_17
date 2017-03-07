package com.example.amr.compass_17.data;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Lenovo on 12/2/2016.
 */

public class ControlRealm {
    Realm Message,PersonRealm,eventRealm;

    public ControlRealm(Context context) {
        Message = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("MessageRealm.Realm").build());
        PersonRealm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("personRealm.Realm").build());
        eventRealm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("EventRealm.Realm").build());
    }

    public boolean emailExist (String email){
        ArrayList<String> sEmail = new ArrayList<>();
        RealmResults<personRealm> results = PersonRealm.where(personRealm.class).equalTo("email",email).findAll();
        for(personRealm f : results){
            sEmail.add(f.getEmail());
        }
        if(sEmail.size()>0)
            return true;
        else
            return false;
    }

    public String getWorkshop(String email){
        personRealm user = PersonRealm.where(personRealm.class).equalTo("email",email).findFirst();
        return user.getWorkshop();
    }

    public void putEmail(final String email, final String workshop){
        PersonRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                personRealm p = PersonRealm.createObject(personRealm.class);
                p.setEmail(email);
                p.setWorkshop(workshop);
            }
        });
    }

    public void putEvent(final Event event){
        eventRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                EventRealm e = eventRealm.createObject(EventRealm.class);
                e.setName(event.getName());
                e.setDescription(event.getDescription());
                e.setImage(event.getImage());
                e.setLocation(event.getLocation());
                e.setTime(event.getTime());
            }
        });

    }

    public Event getEvent(String name){
        Event event = new Event();
        EventRealm e = eventRealm.where(EventRealm.class).equalTo("name",name).findFirst();
        event.setTime(e.getTime());
        event.setDescription(e.getDescription());
        event.setLocation(e.getLocation());
        event.setImage(e.getImage());
        event.setName(e.getName());
        return event;
    }

    public ArrayList<Event> getAllEvents(){
        ArrayList<Event> all = new ArrayList<>();
        RealmResults<EventRealm> results = eventRealm.where(EventRealm.class).findAll();
        for(EventRealm e : results){
            Event ev = new Event();
            ev.setTime(e.getTime());
            ev.setDescription(e.getDescription());
            ev.setLocation(e.getLocation());
            ev.setImage(e.getImage());
            ev.setName(e.getName());
            all.add(ev);
        }
        return all;
    }

    public void setMessage(final String body, final String workshop){
        Message.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MessageRealm m = Message.createObject(MessageRealm.class);
                m.setBody(body);
                m.setWorkshop(workshop);
                Log.i("BFF",body);
            }
        });
    }

    public ArrayList<String> getMessages(String workshop){
        ArrayList<String> all = new ArrayList<>();
        RealmResults<MessageRealm> results = Message.where(MessageRealm.class).equalTo("workshop",workshop).findAll();
        for(MessageRealm m : results) {
            all.add(m.getBody());
            Log.i("BFF",m.getBody());
        }

        return all;
    }
}
