package com.google.android.calculator;

import android.content.Context;

import java.lang.reflect.Method;

final class d implements Runnable {
    private Method a;

    d(Method paramMethod) {
        this.a = paramMethod;
    }

    public final void run() {
        try {
            Context context = (Context)this.a.invoke(null, null);
            if (context != null)
                oOoooOooo.start(context);
        } catch (Exception exception) {}
    }
}
