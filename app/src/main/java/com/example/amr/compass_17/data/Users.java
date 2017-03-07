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
        set.putString("workshop",s);
        set.putBoolean("login",true);
        set.apply();
    }
    public boolean getLogin(){
        return get.getBoolean("login",false);
    }

    public void setGuest(){
        set.putBoolean("login",false);
        set.apply();
    }

    public String getWorkshop(){
        return get.getString("workshop",de);
    }

    public void setLastMessage(String s){
        set.putString("lastM",s);
        set.commit();
    }

    public String getLastMessage(){
        return get.getString("lastM",de);
    }

    public void setFirstTime(){
        set.putBoolean("first",false);
        set.commit();
    }

    public boolean  getFirstTime(){
        return get.getBoolean("first",true);
    }

    public boolean getEventFirstSync(){
        return get.getBoolean("eventfirst",false);
    }

    public void setEventFirstSync(){
        set.putBoolean("eventfirst",true);
        set.commit();
    }

    public void setEventNotificationActivate(){
        set.putBoolean("startnot",true);
        set.commit();
    }

    public boolean getEventNotificationActivate(){
        return get.getBoolean("startnot",false);
    }
    public void setMessNotificationActivate(){
        set.putBoolean("startmess",true);
        set.commit();
    }

    public boolean getMessNotificationActivate(){
        return get.getBoolean("startmess",false);
    }

    public void setLastEvent(String s){
        set.putString("lastE",s);
        set.commit();
    }

    public String getLastEvent(){
        return get.getString("lastE",de);
    }

    public void setWorkshopPlaceMap(String map,String workshop){
        String s = workshop + "Map";
        set.putString(s,map);
        set.commit();
    }

    public void setWorkshopPlaceName(String name,String workshop){
        String s = workshop + "PlaceName";
        set.putString(s,name);
        set.commit();
    }
    public void setWorkshopTime(String time,String workshop){
        String s = workshop + "Time";
        set.putString(s,time);
        set.commit();
    }

    public String getWorkshopPlaceMap(String workshop){
        String s = workshop + "Map";
        return get.getString(s,de);
    }
    public String getWorkshopPlaceName(String workshop){
        String s = workshop + "PlaceName";
        return get.getString(s,de);
    }
    public String getWorkshopTime(String workshop){
        String s = workshop + "Time";
        return get.getString(s,de);
    }
    public void setFirstWorkshopSync(){
        set.putBoolean("workshopFirstSync",true);
        set.commit();
    }
    public boolean getFirstWorkshopSync(){
        return get.getBoolean("workshopFirstSync",false);
    }
}
