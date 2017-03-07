package com.example.amr.compass_17.data;

import io.realm.RealmObject;

/**
 * Created by Lenovo on 3/7/2017.
 */

public class MessageRealm extends RealmObject {
    String workshop,body;

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
