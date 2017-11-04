package com.example.android.sunshine.sync;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

// COMPLETED (9) Create a class called SunshineSyncUtils
    //  COMPLETED (10) Create a public static void method called startImmediateSync
    //  COMPLETED (11) Within that method, start the SunshineSyncIntentService
public class SunshineSyncUtils{
    public static void startImmediateSync(@NonNull Context context){
        Intent intentSync = new Intent(context, SunshineSyncIntentService.class);
        context.startService(intentSync);
    }
}