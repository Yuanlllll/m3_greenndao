package com.example.dell.m3_greenndao.myapp;

import android.app.Application;

import com.example.dell.m3_greenndao.utils.GreendaoUtils;

public class MyAp extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        GreendaoUtils.getInstance().initGreenDao(this);
    }
}
