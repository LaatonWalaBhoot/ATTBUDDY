package home.attbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aishwarya on 7/25/2016.
 */
public class Database_Helper_User extends SQLiteOpenHelper {

    public static final String DATABASE_NAME1 = "name.db";
    public static final String TABLE_NAME1 = "tablename";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "STATE";

    public Database_Helper_User(Context context) {

        super(context, DATABASE_NAME1, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,STATE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME1);
        onCreate(db);

    }

    public void insert(String name,String state)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,state);
        db.insert(TABLE_NAME1,null,contentValues);
    }

    public void update(String name,String state)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3,state);
        db.update(TABLE_NAME1,contentValues,"NAME=?",new String[] {name});
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME1,null);
        return res;
    }

    public void delete()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME1);
    }
}
