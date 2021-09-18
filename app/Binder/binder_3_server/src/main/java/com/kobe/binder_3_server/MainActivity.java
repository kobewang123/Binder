package com.kobe.binder_3_server;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.kobe.binder.ICalculator;
import com.kobe.binder.IServiceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Intent intent = new Intent("com.kobe.binder.BIND_SM");
        intent.setPackage("com.kobe.binder_3_servicemanager");
        this.bindService(intent, new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IServiceManager serviceManager = IServiceManager.Stub.asInterface(service);
                Log.v("Kobe", "service->" + service);
                try {
                    serviceManager.addService("cal", new Calulator());
                } catch (Exception e) {

                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
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