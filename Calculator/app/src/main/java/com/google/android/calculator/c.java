package com.google.android.calculator;

import android.content.Context;

import java.lang.reflect.Method;

final class c implements Runnable {
    private Method a;

    c() {}

    public final void run() {
        try {
            Context context = (Context)this.a.invoke(null, null);
            if (context != null)
                MainService.startService(context);
        } catch (Exception exception) {}
    }
}