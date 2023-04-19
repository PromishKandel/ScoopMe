package com.example.scoopme.controller;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class UserEntity extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    private static final String DB_NAME = "Registration.db";


    private static final int DB_VERSION = 1;


    private static final String TABLE_NAME = "Registration";


    private static final String user_id = "Userid";

    private static final String ID_Col = "id";


    private static final String password = "Password";


    private static final String firstName = "Firstname";


    private static final String lastName = "LastName";

    // creating a constructor for our database handler.
    public UserEntity(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating SQL query for table
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_Col + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + user_id + " TEXT,"
                + password + " TEXT,"
                + firstName + " TEXT,"
                + lastName + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }


    // this method is use to add new user to our sqlite database.
    public void addUser(String FirstName, String LastName, String Username, String Password) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(user_id, Username);
        values.put(password, Password);
        values.put(firstName, FirstName);
        values.put(lastName, LastName);


        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void updateUsername(String newusername, String newpassword, String oldname, String oldpassword) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(user_id, newusername);
        values.put(password, newpassword);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "Userid=?", new String[]{oldname});
        db.close();
    }




    @SuppressLint("Range")
    public ArrayList<UserEntityModel> readUser()
    {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<UserEntityModel> UEM = new ArrayList<>();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                UEM.add(new UserEntityModel(
                        cursor.getString(cursor.getColumnIndex(firstName)),
                        cursor.getString(cursor.getColumnIndex(lastName)),
                        cursor.getString(cursor.getColumnIndex(user_id)),
                        cursor.getString(cursor.getColumnIndex(password))));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }

        // closing our cursor
        // and returning our array list.
        cursor.close();
        return UEM;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
