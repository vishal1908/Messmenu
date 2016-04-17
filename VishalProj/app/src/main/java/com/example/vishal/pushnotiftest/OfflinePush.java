package com.example.vishal.pushnotiftest;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

/**
 * Created by VISHAL  on 09-12-2015.
 */
public class OfflinePush extends Application {

    @Override
    public void onCreate(){

        Parse.initialize(this, "lQvBTVxchLjf2z0k5oqVVk2C7uwXqt4J7zSWyY8u", "aLsoffSltuvpz42TykUj33sDAF6hFyFVfAbriLvR");
        PushService.setDefaultPushCallback(getApplicationContext(), TestPush.class);
        //ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
