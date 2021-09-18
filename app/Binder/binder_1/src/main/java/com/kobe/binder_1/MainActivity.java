package com.kobe.binder_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Intent intent = new Intent(this, MyService.class);
        this.bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IBinder calculator = service;
                Log.v("Kobe", "service->" + service);
                try {
                    int a = 3;
                    int b = 4;

                    Parcel data1 = Parcel.obtain();
                    data1.writeInt(a);
                    data1.writeInt(b);
                    Parcel reply1 = Parcel.obtain();
                    service.transact(1, data1, reply1, 0);
                    int x = reply1.readInt();
                    Log.v("Kobe", a + " + " + b + " = " + x);


                    Parcel data2 = Parcel.obtain();
                    data2.writeInt(a);
                    data2.writeInt(b);
                    Parcel reply2 = Parcel.obtain();
                    service.transact(2, data2, reply2, 0);
                    int y = reply2.readInt();
                    Log.v("Kobe", a + " + " + b + " = " + y);
                } catch (Exception e) {

                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }
}