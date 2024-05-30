package com.google.android.calculator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MainBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(paramIntent.getAction()))
            MainService.startService(paramContext);
    }
}
