package com.example.amr.compass_17.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Lenovo on 2/22/2017.
 */

public class personRealm extends RealmObject {
    @PrimaryKey
    String email;

    String workshop;

    public personRealm(){}

    public personRealm(String email, String workshop) {
        this.email = email;
        this.workshop = workshop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }
}
