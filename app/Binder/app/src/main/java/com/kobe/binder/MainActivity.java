package com.kobe.binder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.kobe.binder_3_client.R;

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
                ICalculator calculator = ICalculator.Stub.asInterface(service);
                Log.v("Kobe", "service->" + service);
                try {
                    int a = 3;
                    int b = 4;
                    int x = calculator.add(a, b);
                    Log.v("Kobe", a + " + " + b + " = " + x);
                    int y = calculator.sub(a, b);
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