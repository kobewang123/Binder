package com.kobe.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private IBinder mCalculator;

    @Override
    public void onCreate() {
        super.onCreate();
        mCalculator = new Calulator();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mCalculator;
    }

    public class Calulator extends ICalculator.Stub {
        @Override
        public int add(int a, int b) throws RemoteException {
            Log.v("Kobe", "a = " + a + " b = " + b + " function = add");
            return a + b;
        }

        @Override
        public int sub(int a, int b) throws RemoteException {
            Log.v("Kobe", "a = " + a + " b = " + b + " function = sub");
            return a - b;
        }
    }
}




