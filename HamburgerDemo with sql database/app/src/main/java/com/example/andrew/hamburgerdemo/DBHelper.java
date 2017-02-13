package com.example.andrew.hamburgerdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrew on 2/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "STUDENT";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME= "STUDENT_NAME";
    private static final String COL_ID= "ID";
    private static final String COL_NAME= "NAME";
    private static final String COL_PHONE= "PHONE";


    SQLiteDatabase mSqliteDatabase;
    public DBHelper(Context context){ super (context, DB_NAME,null, DB_VERSION);}



    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table ="Create Table "+ TABLE_NAME +"("+ COL_ID + " INTERGER PRIMARY KEY," + COL_NAME + " TEXT," + COL_PHONE + " TEXT);";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void insertStudent(String name, String phone){
        mSqliteDatabase = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COL_NAME,name);
        values.put(COL_PHONE,phone);

        mSqliteDatabase.insert(TABLE_NAME,null,values);
        mSqliteDatabase.close();
    }

}
