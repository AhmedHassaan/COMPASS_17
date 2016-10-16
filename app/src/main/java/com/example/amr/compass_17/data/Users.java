package com.example.amr.compass_17.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lenovo on 10/16/2016.
 */

public class Users {
    Context context;
    private SharedPreferences.Editor set;
    private SharedPreferences get;
    String de = "N/A";
    public Users(Context context){
        this.context = context;
        get = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        set = context.getSharedPreferences("user",context.MODE_PRIVATE).edit();
    }

    public void setLogin(String s){
        set.putString("email",s);
        set.putBoolean("login",true);
        set.apply();
    }
    public boolean getLogin(){
        return get.getBoolean("login",false);
    }

}
