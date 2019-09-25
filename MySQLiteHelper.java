package com.example.itaykan.a24919_b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "Users";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";

    public MySQLiteHelper(Context context) {
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER," + " " + COL_NAME + " TEXT " + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
    }

    public boolean insertData(Person p) {
        SQLiteDatabase db = this.getWritableDatabase();

//        int user_id = 1;
//        String user_name = "Menahem";

        ContentValues contentValues = new ContentValues();
//
        contentValues.put(COL_ID, p.getUser_id());
        contentValues.put(COL_NAME, p.getUser_name());

        if (db.insert(TABLE_NAME, null, contentValues) != -1) {
            return true;
        }
        return false;
    }
}
