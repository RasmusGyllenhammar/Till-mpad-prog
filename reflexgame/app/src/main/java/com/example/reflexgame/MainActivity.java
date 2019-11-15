package com.example.reflexgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b_start, b_main;
    long _startTime;
    long _endTime;
    long _currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_start = (Button) findViewById(R.id.b_start);
        b_main = (Button) findViewById(R.id.b_main);

        b_start.setEnabled(true);
        b_main.setEnabled(false);



        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_start.setEnabled(false);

             Handler Handler = new Handler();
             Handler.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     _startTime = System.currentTimeMillis();
                     b_main.setBackgroundColor(
                             ContextCompat.getColor(getApplicationContext(),R.color.blue));
                    b_main.setText("PRESS");

                     b_main.setEnabled(true);

                 }
             },2000);
            }
        });



        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _endTime = System.currentTimeMillis();
                _currentTime = _endTime - _startTime;
                b_main.setBackgroundColor(
                        ContextCompat.getColor(getApplicationContext(),R.color.red));
                b_main.setText(_currentTime + "ms");
                b_start.setEnabled(true);
                b_main.setEnabled(false);
            }
        });
    }
}
