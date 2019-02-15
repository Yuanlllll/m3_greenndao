package com.example.dell.m3_greenndao.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SyncStateContract;

import com.example.dell.m3_greenndao.Constants;
import com.example.dell.m3_greenndao.greendao.DaoMaster;
import com.example.dell.m3_greenndao.greendao.DaoSession;

public class GreendaoUtils
{
    private  static  GreendaoUtils instance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private  GreendaoUtils()
    {

    }

    /*
    * 双重检索
    * */
    public static GreendaoUtils getInstance()
    {
        if(instance==null)
        {
            synchronized (GreendaoUtils.class)
            {
                if (instance==null)
                {
                    instance= new GreendaoUtils();
                }

            }
        }
        return instance;
    }

    //初始化greendao
    public  void  initGreenDao(Context context)
    {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, Constants.DB_NAME);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        //创建daosession
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession()
    {
        return daoSession;
    }

}
