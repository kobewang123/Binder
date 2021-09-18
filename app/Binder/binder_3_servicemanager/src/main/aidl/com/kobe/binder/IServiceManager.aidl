// IServiceManager.aidl
package com.kobe.binder;

// Declare any non-default types here with import statements

interface IServiceManager {

    void addService(String name, IBinder service);
    IBinder getService(String name);
}