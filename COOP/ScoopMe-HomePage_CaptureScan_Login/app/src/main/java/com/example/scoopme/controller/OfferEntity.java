package com.example.scoopme.controller;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class OfferEntity extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    private static final String DB_NAME = "Offer_database.db";


    private static final int DB_VERSION = 1;


    private static final String TABLE_NAME = "Offer";


    private static final String startpoint = "Startpoint";

    private static final String ID_Col = "id";


    private static final String destination = "Destination";



    // creating a constructor for our database handler.
    public OfferEntity(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating SQL query for table
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_Col + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + startpoint + " TEXT,"
                + destination + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }


    // this method is use to add new user to our sqlite database.
    public void addoffer(String Startpoint, String Destination) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(startpoint, Startpoint);
        values.put(destination, Destination);


        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }



    @SuppressLint("Range")
    public ArrayList<OfferEntityModel> readUser()
    {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<OfferEntityModel> OEM = new ArrayList<>();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                OEM.add(new OfferEntityModel(
                        cursor.getString(cursor.getColumnIndex(startpoint)),
                        cursor.getString(cursor.getColumnIndex(destination))));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }

        // closing our cursor
        // and returning our array list.
        cursor.close();
        return OEM;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
