package com.example.adam.ptcma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String phone, String email, String address, String picture) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.NAME, name);
        contentValue.put(DatabaseHelper.PHONE, phone);
        contentValue.put(DatabaseHelper.EMAIL, email);
        contentValue.put(DatabaseHelper.ADDRESS, address);
		contentValue.put(DatabaseHelper.PICTURE, picture);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NAME, DatabaseHelper.PHONE, DatabaseHelper.EMAIL, DatabaseHelper.ADDRESS, DatabaseHelper.PICTURE};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String phone, String email, String address, String picture) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, name);
        contentValues.put(DatabaseHelper.PHONE, phone);
        contentValues.put(DatabaseHelper.EMAIL, email);
        contentValues.put(DatabaseHelper.ADDRESS, address);
		contentValues.put(DatabaseHelper.PICTURE, picture);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}
