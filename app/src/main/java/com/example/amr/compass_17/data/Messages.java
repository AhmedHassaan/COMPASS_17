package com.example.amr.compass_17.data;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Lenovo on 12/2/2016.
 */

public class Messages extends RealmObject {
    @PrimaryKey
    private int id;

    private String body;

    @Ignore
    private String workshop;


    public void setId(int id) {
        this.id = id;
    }

    public void setWorkshop(String workshop) {

        this.workshop = workshop;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getWorkshop() {
        return workshop;
    }
}
