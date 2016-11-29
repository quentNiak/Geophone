package com.example.quent.geophone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    final Context context = this;
    private String nomContact;
    private String numContact;
    private String mailContact;
    private String bluetoothContact;
    private String wifiContact;


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

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });

        buttonAddContactSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                nomContact = editTextNomContact.getText().toString();
                System.out.println("COORDONNES\n\n");
                System.out.println(nomContact+"\n");
                numContact = editTextNumContact.getText().toString();
                System.out.println(numContact+"\n");
                mailContact = editTextMailContact.getText().toString();
                System.out.println(mailContact+"\n");
                bluetoothContact = editTextBluetoothContact.getText().toString();
                System.out.println(bluetoothContact+"\n");
                wifiContact = editTextWifiContact.getText().toString();
                System.out.println(wifiContact+"\n");
            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
    }



}
