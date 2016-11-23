package com.example.quent.geophone;


/**
 * Created by quent on 21/11/2016.
 */

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Listener implements OnClickListener{

    private Button buttonVibrate;
    private Context context;

    public void setContext(Context contextP) {
        this.context = contextP;
    }

    public Listener(Button buttonVibrate)
    {

        this.buttonVibrate = buttonVibrate;

    }


    @Override
    public void onClick(View v) {

        //String context = Context.LOCATION_SERVICE;

        System.out.println("LE TELEPHONE SONNE!!!! \n ");

        Vibrator vib = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 1000 milliseconds
        vib.vibrate(1000);

    }
}
