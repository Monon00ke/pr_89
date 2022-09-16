package com.example.mmm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class New extends AppCompatActivity {

    private MyDbManager myDbManager;
    private EditText who, when, what;
    private TextView TWTEXT;
    int LENGTH_LONG;

    Button create;
    Button nazad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        myDbManager = new MyDbManager(this);
        who = findViewById(R.id.who);
        when = findViewById(R.id.when);
        what = findViewById(R.id.what);
        TWTEXT = findViewById(R.id.TWTEXT);


        Button create = (Button)findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("777","do");

        myDbManager.insertToDb(who.getText().toString(), when.getText().toString(), what.getText().toString());

        for (String fio : myDbManager.getFromDb()){
            Log.d("777",fio);
            TWTEXT.append(fio);
            TWTEXT.append("\n");

        }
                Log.d("777","posle");

            }
        });


        Button nazad = (Button)findViewById(R.id.nazad);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("777","return");
                Intent i;
                i = new Intent(New.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();
        for (String fio : myDbManager.getFromDb()){
            TWTEXT.append(fio);
            TWTEXT.append("\n");

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDbManager.closeDb();
    }


//    public void next(View view){
//
  //      Toast.makeText(this, "to search", Toast.LENGTH_LONG).show();
    //    Intent intent = new Intent(this, Find.class);
      //  startActivity(intent);
   // }


}