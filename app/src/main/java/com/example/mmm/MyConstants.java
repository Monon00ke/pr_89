package com.example.mmm;

public class MyConstants {
    public static final String TABLE_NAME = "my_table";
    public static final String _ID = "_id";
    public static final String FIO = "fio";
    public static final String DATE = "date";
    public static final String WHAT_BUY = "what_buy";
    public static final String DB_NAME = "my_db.db";
    public static final int DB_VERSION = 2;

    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME +
            " (" + _ID + " INTEGER PRIMARY KEY," +
            FIO + " TEXT," +
            DATE + " TEXT," +
            WHAT_BUY + " TEXT)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;

}
