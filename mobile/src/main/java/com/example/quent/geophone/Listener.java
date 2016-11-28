package com.example.quent.geophone;


/**
 * Created by quent on 21/11/2016.
 */

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Listener implements OnClickListener{

    private Button button;
    //private Button buttonCall;
    private Context context;
    //private BluetoothAdapter BA;
    private Intent enableBtIntent;

    public void setContext(Context contextP) {
        this.context = contextP;
    }

    //public Listener(Button buttonVibrate, Button buttonCall)
    //public Listener(Button button, Intent enableBtIntent)
    public Listener(Button button)
    {

        this.button = button;
        //this.enableBtIntent = enableBtIntent;

    }




    @Override
    public void onClick(View v) {

        //String context = Context.LOCATION_SERVICE;

        System.out.println("LE TELEPHONE SONNE!!!! \n ");

        Vibrator vib = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 1000 milliseconds
        vib.vibrate(1000);

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:0610466129"));

        /*BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
        Intent turnOnBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        //turnOnBluetooth.
        if (BA == null)
            //Toast.makeText(MainActivity.this, "Pas de Bluetooth",Toast.LENGTH_SHORT).show();
            System.out.println("Pas de Bluetooth");
        else
            //Toast.makeText(MainActivity.this, "Avec Bluetooth",Toast.LENGTH_SHORT).show();
            System.out.println("Avec Bluetooth");

        if (!BA.isEnabled()) {
            //BA.enable();
            //Toast.makeText(getApplicationContext(), "Turned on", Toast.LENGTH_LONG).show();
            System.out.println("Avec Bluetooth");
        }*/




        //Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);


    }




}
