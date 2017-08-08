package home.attbuddy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aishwarya on 9/10/2016.
 */
public class Database_Helper_Reminders extends SQLiteOpenHelper {

    public static final String DATABASE_NAME6 = "reminders.db";
    public static final String TABLE_NAME6 = "data";
    public static final String COL1 = "ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "SUBJECT";
    public static final String COL4 = "FACULTY";

    public Database_Helper_Reminders(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
