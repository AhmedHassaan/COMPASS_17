package com.example.amr.compass_17.data;

/**
 * Created by Lenovo on 12/2/2016.
 */

public class OneMessage {
    String body;
    String workshop;

    public OneMessage(String body) {
        this.body = body;
        workshop = "";
    }

    public OneMessage(String body, String workshop) {
        this.body = body;
        this.workshop = workshop;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }
}
