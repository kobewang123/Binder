package com.kobe.binder_2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;
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
            return a + b;
        }

        @Override
        public int sub(int a, int b) throws RemoteException {
            return a - b;
        }
    }
}
