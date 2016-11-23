package com.example.quent.geophone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart()
    {
        super.onStart();
        Button buttonVibrate = (Button) findViewById(R.id.buttonVibrate);

        Listener buttonListener = new Listener(buttonVibrate);
        buttonListener.setContext(getApplicationContext());
        buttonVibrate.setOnClickListener(buttonListener);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
