package com.example.quent.geophone;

import android.*;
import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    //private final static int REQUEST_ENABLE_BT = 0;
    final Context context = this;
    private Bundle testBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        testBundle = savedInstanceState;
        super.onCreate(testBundle);
        setContentView(R.layout.activity_main);
        //testBundle = savedInstanceState;

        //addListenerOnButton();

    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        //addListenerOnButton();

        Button buttonVibrate = (Button) findViewById(R.id.buttonVibrate);
        Button buttonCall = (Button) findViewById(R.id.buttonCall);


        Intent callIntent = new Intent(Intent.ACTION_CALL);
        //Intent callIntent = new Intent(Intent.ACTION_CALL);


        Listener buttonVibrateListener = new Listener(buttonVibrate);
        Listener buttonCallListener = new Listener(buttonCall);

        buttonVibrateListener.setContext(getApplicationContext());
        buttonCallListener.setContext(getApplicationContext());


        buttonVibrate.setOnClickListener(buttonVibrateListener);
        //buttonCall.setOnClickListener(buttonCallListener);

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0668292738"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overridng
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    System.out.println("Hello");
                    return;
                }
                startActivity(callIntent);
                System.out.println("Hello");


              }
        });






        Button buttonBluetoothON = (Button) findViewById(R.id.buttonBluetoothON);
        Button buttonBluetoothOFF = (Button) findViewById(R.id.buttonBluetoothOFF);
        Button buttonGetBluetooth = (Button) findViewById(R.id.buttonGetBluetooth);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //ListView lv = (ListView)findViewById(R.id.listView);

        if (bluetoothAdapter == null) {
            // Le terminal ne possède pas le Bluetooth
        }
        else System.out.println("BLUETOOTH!!!!");


        buttonBluetoothON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothAdapter.isEnabled()) {
                    Toast.makeText(getApplicationContext(),
                            "Turning ON Bluetooth", Toast.LENGTH_LONG);
                    // Intent enableBtIntent = new
                    // Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(new Intent(
                            BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
                }
            }
        });


        buttonBluetoothOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(),
                        "TURNING OFF BLUETOOTH", Toast.LENGTH_LONG);
                }
        });





        /*buttonGetBluetooth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                *//*final BroadcastReceiver receiver = new BroadcastReceiver()
                {
                    public void onReceive(Context context, Intent intent)
                    {
                        String action = intent.getAction();
                        // Quand la recherche trouve un terminal
                        if (BluetoothDevice.ACTION_FOUND.equals(action))
                        {
                            Spinner spinner = (Spinner) findViewById(R.id.spinner);
                            ArrayAdapter dataAdapter = new ArrayAdapter();
                            ArrayList list = new ArrayList();
                            List<String> phones = new ArrayList<String>();

                            // On récupère l'object BluetoothDevice depuis l'Intent
                            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                            // Creating adapter for spinner
                            ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);

                            // On ajoute le nom et l'adresse du périphérique dans un ArrayAdapter (par exemple pour l'afficher dans une ListView)
                            dataAdapter.add(device.getName() + "\n" + device.getAddress());

                            // Drop down layout style - list view with radio button
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                            // attaching data adapter to spinner
                            spinner.setAdapter(dataAdapter);
                        }
                    }
                }*//*

                public void list(View v){
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

                ArrayList list = new ArrayList();

                for(BluetoothDevice bt : pairedDevices) list.add(bt.getName());
                Toast.makeText(getApplicationContext(), "Showing Paired Devices",Toast.LENGTH_SHORT).show();

                final ArrayAdapter adapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1, list);

                lv.setAdapter(adapter);
            }
            }
        };

        // Inscrire le BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiver, filter); // N'oubliez pas de le désinscrire lors du OnDestroy() !*/

        //public void addListenerOnButton() {
            Button buttonAccueilCreateContact = (Button) findViewById(R.id.buttonAccueilCreateContact);

            buttonAccueilCreateContact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                    System.out.println("VA A LECRAN AJOUT CONTACT BATARD!!");
                    startActivity(intent);
                    finish();

                }

            });

        Button buttonAccueilManageContact = (Button) findViewById(R.id.buttonManageContact);

        buttonAccueilManageContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ManageContactActivity.class);
                System.out.println("VA A LECRAN GESTION CONTACT BATARD!!");
                startActivity(intent);
                finish();

            }

        });

       // }

        /*if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);*/

}


    @Override
    public void onStop() {
        super.onStop();

    }


}
