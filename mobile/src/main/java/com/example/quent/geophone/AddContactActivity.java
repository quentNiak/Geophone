package com.example.quent.geophone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity {

    final Context context = this;
    private String nomContact;
    private String numContact;
    private String mailContact;
    private String bluetoothContact;
    private String wifiContact;

    private Contact newContact;
    CheckedTextView descriptionVue = null;


    @Override
    protected void onStart()
    {
        super.onStart();
        setContentView(R.layout.activity_addcontact);

        Button buttonAddContactBack = (Button) findViewById(R.id.buttonAddContactBack);
        Button buttonAddContactSave = (Button) findViewById(R.id.buttonAddContactSave);

        final EditText editTextNomContact = (EditText) findViewById(R.id.editTextNomContact);
        final EditText editTextNumContact = (EditText) findViewById(R.id.editTextNumContact);
        final EditText editTextMailContact = (EditText) findViewById(R.id.editTextMailContact);
        final EditText editTextBluetoothContact = (EditText) findViewById(R.id.editTextBluetoothContact);
        final EditText editTextWifiContact = (EditText) findViewById(R.id.editTextWIFIContact);


        buttonAddContactBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),"ECRAN AJOUT CONTACT: REVENIR A L'ECRAN D'ACCUEIL",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });

        /*buttonAddContactSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),"ECRAN AJOUT CONTACT: SAUVEGARDE CONTACT",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });*/

        buttonAddContactSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Contact newContact = new Contact();

                Toast.makeText(getApplicationContext(),"ECRAN AJOUT CONTACT: SAUVEGARDE CONTACT",Toast.LENGTH_SHORT).show();

                nomContact = editTextNomContact.getText().toString();
                newContact.setNomContact(nomContact);
                System.out.println("COORDONNES\n\n");
                //System.out.println(nomContact+"\n");
                System.out.println(newContact.getNomContact()+"\n");

                numContact = editTextNumContact.getText().toString();
                newContact.setTelContact(numContact);
                //System.out.println(numContact+"\n");
                System.out.println(newContact.getTelContact()+"\n");

                mailContact = editTextMailContact.getText().toString();
                newContact.setMailContact(mailContact);
                //System.out.println(mailContact+"\n");
                System.out.println(newContact.getMailContact()+"\n");

                bluetoothContact = editTextBluetoothContact.getText().toString();
                newContact.setBluetoothContact(bluetoothContact);
                //System.out.println(bluetoothContact+"\n");
                System.out.println(newContact.getBluetoothContact()+"\n");

                wifiContact = editTextWifiContact.getText().toString();
                newContact.setWifiContact(wifiContact);
                //System.out.println(wifiContact+"\n");
                System.out.println(newContact.getWifiContact()+"\n");

                /*CheckedTextView detail;
                int nbContact = 0;

                nbContact++;



                LinearLayout llay = (LinearLayout)findViewById(R.id.linearLayout1);


                for (int i = 0; i < newContact.incNbContact(); i++) {
                    detail = new CheckedTextView(fragmentView.getContext());
                    detail.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    detail.setText(detailsArray[i]);
                    llay.addView(detail);
                }

                ScrollView sv = (ScrollView) fragmentView.findViewById(R.id.scrollView1);
                sv.invalidate();
                sv.requestLayout();*/


            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
    }



}
