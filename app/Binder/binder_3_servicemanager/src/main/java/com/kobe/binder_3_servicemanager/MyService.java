package com.kobe.binder_3_servicemanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.kobe.binder.IServiceManager;

import java.util.HashMap;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private IBinder mServiceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mServiceManager = new SerivceManager();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mServiceManager;
    }

    public class SerivceManager extends IServiceManager.Stub {

        private HashMap<String, IBinder> mServiceList = new HashMap<>();

        @Override
        public void addService(String name, IBinder service) throws RemoteException {
            Log.v("Kobe", "addServie " + " name = " + name + " service = " + service);
            mServiceList.put(name, service);
        }

        @Override
        public IBinder getService(String name) throws RemoteException {
            Log.v("Kobe", "getService " + " name = " + name);
            return mServiceList.get(name);
        }
    }
}
