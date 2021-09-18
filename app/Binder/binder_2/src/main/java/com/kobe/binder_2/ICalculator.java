package com.kobe.binder_2;

import android.os.Parcel;

public interface ICalculator {

    public static abstract class Stub extends android.os.Binder implements com.kobe.binder_2.ICalculator {
        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            if (code == 1) {
                int a = data.readInt();
                int b = data.readInt();
                int x = add(a, b);
                reply.writeInt(x);
                return true;
            } else if (code == 2) {
                int a = data.readInt();
                int b = data.readInt();
                int y = sub(a, b);
                reply.writeInt(y);
                return true;
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    public static class Proxy implements com.kobe.binder_2.ICalculator {
        private android.os.IBinder mRemote;

        public Proxy(android.os.IBinder remote) {
            mRemote = remote;
        }

        @Override
        public int add(int a, int b) throws android.os.RemoteException {
            Parcel data1 = Parcel.obtain();
            data1.writeInt(a);
            data1.writeInt(b);
            Parcel reply1 = Parcel.obtain();
            mRemote.transact(1, data1, reply1, 0);
            int x = reply1.readInt();
            return x;
        }

        @Override
        public int sub(int a, int b) throws android.os.RemoteException {
            Parcel data1 = Parcel.obtain();
            data1.writeInt(a);
            data1.writeInt(b);
            Parcel reply1 = Parcel.obtain();
            mRemote.transact(2, data1, reply1, 0);
            int y = reply1.readInt();
            return y;
        }
    }

    public int add(int a, int b) throws android.os.RemoteException;

    public int sub(int a, int b) throws android.os.RemoteException;
}
