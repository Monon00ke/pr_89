package com.example.mmm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mmm.MyConstants;
import com.example.mmm.MyDbHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDbManager {
    private Context context;
    private final MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    public MyDbManager(Context context) {
        this.context = context;
        myDbHelper = new MyDbHelper(context);

    }

    public void openDb(){
        db = myDbHelper.getWritableDatabase();

    }

    public void insertToDb(String fio, String date, String what_buy){
        ContentValues cv = new ContentValues();
        cv.put(MyConstants.FIO, fio);
        cv.put(MyConstants.DATE, date);
        cv.put(MyConstants.WHAT_BUY, what_buy);
        db.insert(MyConstants.TABLE_NAME, null, cv);
    }
    public List<String> getFromDb() {
        List<String> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyConstants.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()){
            String fio = cursor.getString(cursor.getColumnIndexOrThrow(MyConstants.FIO));
            tempList.add(fio);

        }
        cursor.close();
        return tempList;

    }
    public void closeDb(){
        myDbHelper.close();

    }
}
