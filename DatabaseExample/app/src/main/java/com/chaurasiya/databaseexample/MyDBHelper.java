package com.chaurasiya.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT = "contacts";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PHONE_NO="phone_no";


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_no TEXT);
        // --> QUERY WILL BE CREATED LIKE THIS;
        db.execSQL("CREATE TABLE "+ TABLE_CONTACT+
                "("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME+" TEXT,"+KEY_PHONE_NO+" TEXT"+")");

//        to get database reference of the current app use command
//        SQLiteDatabase database = this.getWritableDatabase();
//        to close database access
//        database.close();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);
        onCreate(db);
    }
    public void addContact (String name , String number ){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NO, number);
        database.insert(TABLE_CONTACT, null,values);
    }
    public ArrayList<StructureClassArray> fetchContact(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_CONTACT, null);
        ArrayList<StructureClassArray> arrContacts = new ArrayList<>();

        while (cursor.moveToNext()){
            StructureClassArray model = new StructureClassArray();
            model.id= cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phoneNumber= cursor.getString(2);
            arrContacts.add(model);
        }
        return arrContacts;
    }
    public void updateContact(StructureClassArray structureClassArray){
        SQLiteDatabase database  = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_PHONE_NO, structureClassArray.phoneNumber);
        cv.put(KEY_NAME, structureClassArray.name);
        database.update(TABLE_CONTACT, cv, KEY_ID+ " = " + structureClassArray.id,null );
    }
    public void deleteContact (int id ){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_CONTACT, KEY_ID+" = ? ", new String[]{String.valueOf(id)});
    }

}
