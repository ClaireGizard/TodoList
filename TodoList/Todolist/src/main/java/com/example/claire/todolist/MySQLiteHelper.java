package com.example.claire.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by claire on 11/01/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_TASKS = "taks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_DATE ="date";
    public static final String COLUMN_CHECK = "check_done";

    private static final String DATABASE_NAME = "task.db";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_TASKS
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null,"
            + COLUMN_CONTENT + " text not null,"
            + COLUMN_DATE + " date not null,"
            + COLUMN_CHECK + " integer not null"
            + ");";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }
}
