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
    Realm MessageRealm,PersonRealm;

    public ControlRealm(Context context) {
        MessageRealm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("Messages.Realm").build());
        PersonRealm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("personRealm.Realm").build());
    }

    public void putMessage(final Message message){
        MessageRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Messages messages = realm.createObject(Messages.class);
                messages.setBody(message.getBody());
                messages.setWorkshop(message.getWorkshop());
                messages.setId(getNextKey());
            }
        });
    }

    public ArrayList<Message> getAllMessages(){
        ArrayList<Message> all = new ArrayList<>();
        RealmResults<Messages> results = MessageRealm.where(Messages.class).findAll();
        for (Messages mm:results){
            Message m = new Message(mm.getBody(),mm.getWorkshop());
            all.add(m);
        }
        return all;
    }

    private int getNextKey()
    {
        return MessageRealm.where(Messages.class).max("id").intValue() + 1;
    }

    public boolean emailExist (String email){
        ArrayList<person> sEmail = new ArrayList<>();
        RealmResults<personRealm> results = PersonRealm.where(personRealm.class).equalTo("email",email).findAll();
        for(personRealm f : results){
            person p = new person(f.getEmail(),f.getWorkshop());
            sEmail.add(p);
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

}
