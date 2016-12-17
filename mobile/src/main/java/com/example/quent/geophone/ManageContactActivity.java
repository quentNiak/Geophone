package com.example.quent.geophone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ManageContactActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_manage_contact);

        Button buttonManageContactBackToMain = (Button) findViewById(R.id.buttonManageContactBack);


        buttonManageContactBackToMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_contact);
    }
}
