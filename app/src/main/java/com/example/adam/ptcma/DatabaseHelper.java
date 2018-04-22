package com.example.adam.ptcma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    static final String TABLE_NAME = "CUSTOMERS";

    // Table columns
    static final String _ID = "_id";
    static final String NAME = "name";
    static final String PHONE = "phone";
    static final String EMAIL = "email";
    static final String ADDRESS = "address";
	static final String PICTURE = "picture";


    // Database Information
    static final String DB_NAME = "CUSTOMERS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + PHONE + " TEXT, " + EMAIL + " TEXT, " + ADDRESS + " TEXT, " + PICTURE + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
