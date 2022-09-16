package com.example.mmm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button new_human;
    Button find_human;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button new_human = (Button)findViewById(R.id.new_human);
        Button find_human = (Button) findViewById(R.id.find_human);
        new_human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("777","new");
                Intent i;
                i = new Intent(MainActivity.this, New.class);
                startActivity(i);
            }
        });

        find_human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("777","finding");

                Intent i;
                i = new Intent(MainActivity.this, Finding.class);
                startActivity(i);


            }
        });
    }


}