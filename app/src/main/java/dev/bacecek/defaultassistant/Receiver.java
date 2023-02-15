package dev.bacecek.defaultassistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(ApplicationComponent.getInstance().testJava4().kek());
    }
}
