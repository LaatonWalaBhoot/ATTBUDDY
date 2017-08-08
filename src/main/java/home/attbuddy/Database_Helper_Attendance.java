package home.attbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Aishwarya on 7/26/2016.
 */
public class Database_Helper_Attendance extends SQLiteOpenHelper {

    public static final String DATABASE_NAME3 = "attendance.db";
    public static final String TABLE_NAME3 = "statistics";
    public static final String COL1 = "ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "ATTENDED";
    public static final String COL4 = "TOTAL";


    public Database_Helper_Attendance(Context context) {
        super(context, DATABASE_NAME3, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME3 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,ATTENDED DOUBLE,TOTAL DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
    }

    public void insertAttendance(ArrayList<String> subjects,ArrayList<Double> attended,ArrayList<Double> total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for(int i=0;i<subjects.size();i++)
        {
            contentValues.put(COL2, subjects.get(i));
            contentValues.put(COL3, attended.get(i));
            contentValues.put(COL4, total.get(i));
            db.insert(TABLE_NAME3, null, contentValues);
            contentValues.clear();
        }
    }

    public void insertAttendanceLater(String subjects,Double attended,Double total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, subjects);
        contentValues.put(COL3, attended);
        contentValues.put(COL4, total);
        db.insert(TABLE_NAME3, null, contentValues);
        contentValues.clear();
    }

    public void updateDetails(String title,Double att,double tot)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3,att);
        contentValues.put(COL4,tot);
        db.update(TABLE_NAME3,contentValues,"TITLE=?",new String[] {title});
    }

    public Cursor getAttended(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="select "+COL3+" from "+ TABLE_NAME3 + " where "+COL2+"=?";
        Cursor get = db.rawQuery(query,new String[] {title});
        return get;
    }

    public Double getNum()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="select "+COL3+" from "+ TABLE_NAME3;
        Cursor get = db.rawQuery(query,null);
        Double num=0.0;
        while(get.moveToNext())
        {
            Double k = get.getDouble(0);
            num = num+k;
        }
        return num;
    }

    public Double getDen()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="select "+COL4+" from "+ TABLE_NAME3;
        Cursor get = db.rawQuery(query,null);
        Double num=0.0;
        while(get.moveToNext())
        {
            Double k = get.getDouble(0);
            num = num+k;
        }
        return num;
    }

    public Cursor getTotal(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="select "+COL4+" from "+ TABLE_NAME3 + " where "+COL2+"=?";
        Cursor get = db.rawQuery(query,new String[] {title});
        return get;
    }

    public void deleteDetails(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "delete from "+ TABLE_NAME3 + " where TITLE=?";
        db.rawQuery(query,new String[] {title});
    }

    public void deleteAllDetails()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME3);
    }
}