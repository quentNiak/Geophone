package com.example.quent.geophone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ManageContactActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_manage_contact);

        Button buttonManageContactBackToMain = (Button) findViewById(R.id.buttonManageContactBack);
        Button buttonModifyContact = (Button) findViewById(R.id.buttonModifyContact);
        Button buttonDeleteContact = (Button) findViewById(R.id.buttonDeleteContact);


        buttonManageContactBackToMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),"ECRAN GESTION CONTACT: " +
                        "REVENIR A L'ECRAN D'ACCUEIL",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });

        buttonModifyContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),"PASSAGE A L'ECRAN MODIFICATION CONTACT",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, AddContactActivity.class);
                startActivity(intent);

            }

        });

        buttonDeleteContact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),"SUPPRESSION CONTACT",Toast.LENGTH_SHORT).show();

            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_contact);
    }
}
