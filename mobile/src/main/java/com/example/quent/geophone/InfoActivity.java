package com.example.quent.geophone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_info);

        Button buttonInfoBackToMain = (Button) findViewById(R.id.buttonBackFromInfoToMain);


        buttonInfoBackToMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),"ECRAN INFO: REVENIR A L'ECRAN D'ACCUEIL",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
}
