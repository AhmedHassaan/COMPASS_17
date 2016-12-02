package com.example.amr.compass_17.data;

import android.content.Context;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Lenovo on 12/2/2016.
 */

public class ControlRealm {
    Realm realm;

    public ControlRealm(Context context) {
        realm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("Messages.Realm").build());
    }

    public void putMessage(final OneMessage message){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Messages messages = realm.createObject(Messages.class);
                messages.setBody(message.getBody());
                messages.setWorkshop(message.getWorkshop());
                messages.setId(getNextKey());
            }
        });
    }

    public ArrayList<OneMessage> getAllMessages(){
        ArrayList<OneMessage> all = new ArrayList<>();
        RealmResults<Messages> results = realm.where(Messages.class).findAll();
        for (Messages mm:results){
            OneMessage m = new OneMessage(mm.getBody(),mm.getWorkshop());
            all.add(m);
        }
        return all;
    }

    public ArrayList<OneMessage> getWorkshopMessages(String workshop){
        ArrayList<OneMessage> all = new ArrayList<>();
        RealmResults<Messages> results = realm.where(Messages.class).equalTo("workshop",workshop).findAll();
        for (Messages mm:results){
            OneMessage m = new OneMessage(mm.getBody(),mm.getWorkshop());
            all.add(m);
        }
        return all;
    }

    public int getNextKey()
    {
        return realm.where(Messages.class).max("id").intValue() + 1;
    }

}
