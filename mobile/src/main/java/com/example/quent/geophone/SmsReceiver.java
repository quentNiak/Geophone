package com.example.quent.geophone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by quent on 17/12/2016.
 */

public abstract class SmsReceiver extends BroadcastReceiver {

    private String numberTel;
    private SmsMessage[] currentSMS;
    private String messageContent;
    private Object[] pdus;
    private final String ACTION_RECEIVE_SMS = "android.provider.Telephony.SMS_RECEIVED";

    protected abstract void onNewSMS(String sms, String phone);

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_RECEIVE_SMS)) {
            //---get the SMS message passed in---
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                //---retrieve the SMS message received---
                pdus = (Object[]) bundle.get("pdus");
                currentSMS = new SmsMessage[pdus.length];

                for (int i = 0; i < pdus.length; i++) {
                    String format = bundle.getString("format");
                    currentSMS[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }

                if (currentSMS.length > -1) {
                    for (int i = 0; i < currentSMS.length; i++) {
                        messageContent += currentSMS[i].getMessageBody();
                    }
                    numberTel = currentSMS[0].getOriginatingAddress();

                    if (currentSMS[0].equals("+33")) {
                        numberTel = currentSMS[0].getDisplayOriginatingAddress().replace("+33", "0");
                        System.out.println("+33 MA GUEULE!!");
                    }

                    onNewSMS(messageContent, numberTel);
                }

                //Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }

        }

    }
}
