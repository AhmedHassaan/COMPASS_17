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
    Realm Message,PersonRealm;

    public ControlRealm(Context context) {
        Message = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("MessageRealm.Realm").build());
        PersonRealm = Realm.getInstance(new RealmConfiguration.Builder(context)
                .name("personRealm.Realm").build());
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


}
