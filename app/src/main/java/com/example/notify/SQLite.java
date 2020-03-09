package com.example.notify;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {
    public static String TABLE_feedback="feedback";




    public static String feedback= "feedback1";


    static String DATABASE_NAME = "UserDataBase";

    public static final String TABLE_NAME = "UserTable";

    public static final String Table_Column_ID = "id";

    public static final String Table_Column_1_Name = "name";

    public static final String Table_Column_2_Email = "email";

    public static final String Table_Column_3_Password = "password";


    public SQLite(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY, " + Table_Column_1_Name + " VARCHAR, " + Table_Column_2_Email + " VARCHAR, " + Table_Column_3_Password + " VARCHAR)";
        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);


    }
    public boolean insertdata3( String feedback1)
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
  ContentValues contvalue = new ContentValues();
        contvalue.put(feedback, feedback1);

        long res = sqLiteDatabase.insert(TABLE_feedback, null, contvalue);


        return res != -1;
    }

}
