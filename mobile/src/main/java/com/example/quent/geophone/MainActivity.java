package com.example.quent.geophone;

import android.*;
import android.Manifest;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.location.Location;

import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.Toast;

import android.support.v4.content.ContextCompat;
import android.app.Activity;



public class MainActivity extends AppCompatActivity {

    //private final static int REQUEST_ENABLE_BT = 0;
    final Context context = this;
    private Bundle testBundle;
    private static final String bluetoothName = "Windows Phone";
    private String requestGPSmessage = "Geophone GPS";
    private String phoneNumber = "0604419214";

    private LocationGPS localisationPerso;
    private double latitudeCible =48.856614;
    private double longitudeCible =2.352221;
    private String deviceName ="telephone Cible";

    private SmsReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        testBundle = savedInstanceState;
        super.onCreate(testBundle);
        setContentView(R.layout.activity_main);

        localisationPerso = new LocationGPS(getApplicationContext());



         // On vérifie les Permissions de l'utilisateur : GPS, SMS, ...
        if(checkForPermissions(this)==true){
            //Si on a les droits
            //initProgram();
            Toast.makeText(getApplicationContext(),"Vous disposez des autorisations nécessaires pour le bon fonctionnement de l'application", Toast.LENGTH_LONG).show();
        }

        else{
            //Si on a pas les droits, on les demande
            Toast.makeText(getApplicationContext(),"Vous ne disposez pas des autorisations suffisantes", Toast.LENGTH_LONG).show();
            permissionManagement();
            //finish();
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        /*Button buttonVibrate = (Button) findViewById(R.id.buttonVibrate);
        Listener buttonVibrateListener = new Listener(buttonVibrate);
        buttonVibrateListener.setContext(getApplicationContext());
        buttonVibrate.setOnClickListener(buttonVibrateListener);*/





        Button buttonBluetoothON = (Button) findViewById(R.id.buttonBluetoothON);
        Button buttonBluetoothOFF = (Button) findViewById(R.id.buttonBluetoothOFF);
        Button buttonGetBluetooth = (Button) findViewById(R.id.buttonGetBluetooth);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice deviceBlue;

        //ListView lv = (ListView)findViewById(R.id.listView);

        if (bluetoothAdapter == null) {
            // Le terminal ne possède pas le Bluetooth
        }
        else System.out.println("BLUETOOTH!!!!");







            Button buttonAccueilCreateContact = (Button) findViewById(R.id.buttonAccueilAddContact);

            buttonAccueilCreateContact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(),"ECRAN ACCUEIL: ALLER A L'ECRAN CREATION CONTACT",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                    startActivity(intent);
                    finish();

                }

            });

        Button buttonAccueilManageContact = (Button) findViewById(R.id.buttonAccueilGererContact);

        buttonAccueilManageContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ManageContactActivity.class);
                Toast.makeText(getApplicationContext(),"ECRAN ACCUEIL: ALLER A L'ECRAN GESTION CONTACT",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();

            }

        });

        Button buttonAccueilSeeInfos = (Button) findViewById(R.id.buttonAccueilInfo);

        buttonAccueilSeeInfos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                Toast.makeText(getApplicationContext(),"ECRAN ACCUEIL: ALLER A LECRAN INFORMATIONS",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();

            }

        });


/*        Button buttonSendSMS = (Button) findViewById(R.id.buttonSendSMS);

        buttonSendSMS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
                intent.putExtra("sms_body", requestGPSmessage);
                startActivity(intent);

            }

        });*/


        Button boutonGPS = (Button) findViewById(R.id.buttonAccueilRechercher);

        boutonGPS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Location localisationActuelle = localisationPerso.getLastLocation();
                Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + localisationActuelle.getLatitude() + "\nLong: " + localisationActuelle.getLongitude(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                //Toast.makeText(getApplicationContext(), "ici", Toast.LENGTH_LONG).show();
                intent.putExtra("latitudeSearch", latitudeCible );
                intent.putExtra("longitudeSearch", longitudeCible);
                intent.putExtra("device name", deviceName);
                startActivity(intent);
                finish();

            }

        });



  /*      Button boutonMAP = (Button) findViewById(R.id.buttonDisplayMap);

        boutonMAP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                //Toast.makeText(getApplicationContext(), "ici", Toast.LENGTH_LONG).show();
                intent.putExtra("latitudeSearch", latitudeCible );
                intent.putExtra("longitudeSearch", longitudeCible);
                intent.putExtra("device name", deviceName);
                startActivity(intent);
                finish();            }

        });*/



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


    // FONCTIONS GPS//

    protected boolean checkForPermissions (Activity activity){

         //Fonction pour connaitre si ont a les permissions necessaires

        //int permissionCheckReadContact= ContextCompat.checkSelfPermission(activity, android.Manifest.permission.READ_CONTACTS);
        int permissionCheckReceiveSMS = ContextCompat.checkSelfPermission(activity, android.Manifest.permission.RECEIVE_SMS);
        int permissionCheckReadSMS = ContextCompat.checkSelfPermission(activity, android.Manifest.permission.READ_SMS);
        int permissionCheckFineLocation = ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCheckCoarseLocation = ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        boolean check=false;

        //On verifie si on a toutes les permissions
        if( permissionCheckReadSMS== PackageManager.PERMISSION_GRANTED &&
                permissionCheckReceiveSMS==PackageManager.PERMISSION_GRANTED &&
                //permissionCheckReadContact==PackageManager.PERMISSION_GRANTED &&
                permissionCheckFineLocation==PackageManager.PERMISSION_GRANTED &&
                permissionCheckCoarseLocation==PackageManager.PERMISSION_GRANTED)
        {
            check=true;
        }

        else if(permissionCheckReadSMS==PackageManager.PERMISSION_DENIED ||
                permissionCheckReceiveSMS==PackageManager.PERMISSION_DENIED ||
                //permissionCheckReadContact==PackageManager.PERMISSION_DENIED ||
                permissionCheckFineLocation==PackageManager.PERMISSION_DENIED ||
                permissionCheckCoarseLocation==PackageManager.PERMISSION_DENIED)
        {
            check=false;
        }

        return check;
    }

    private void permissionManagement(){
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{android.Manifest.permission.READ_SMS,
                android.Manifest.permission.RECEIVE_SMS,
                android.Manifest.permission.READ_CONTACTS,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,}, 8);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 8: {
                // grantResults[0] = -1
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }




}
