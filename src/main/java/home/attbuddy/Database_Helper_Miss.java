package home.attbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aishwarya on 8/14/2016.
 */
public class Database_Helper_Miss extends SQLiteOpenHelper {

    public static final String DATABASE_NAME5 = "miss.db";
    public static final String TABLE_NAME5 = "tablemiss";
    public static final String COL1 = "ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "DAY";

    public Database_Helper_Miss(Context context) {
        super(context, DATABASE_NAME5, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME5 + "(ID INTEGER,TITLE TEXT,DAY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME5);
        onCreate(db);
    }

    public void insert(String id,String title,int day)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,title);
        contentValues.put(COL3,day);
        db.insert(TABLE_NAME5,null,contentValues);
    }

    public void deleteOne(String id,String day)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "delete from "+TABLE_NAME5+" where ID=? and DAY=? ";
        db.execSQL(query,new String[] {id,day});
    }

    public Cursor getSubjectsTitle()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sub = db.rawQuery("select MIN("+COL2+") AS "+COL2+" from "+TABLE_NAME5+" group by "+COL2,null);
        return sub;
    }

    public int getMissTitle(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sub = db.rawQuery("select "+COL2+" from "+TABLE_NAME5,null);
        int count = 0;
        for(int i=0;i<sub.getCount();i++)
        {
            while(sub.moveToNext())
            {
                if(title.equals(sub.getString(0)))
                {
                    count++;
                }
            }
        }
        return count;
    }

    public int getDayValue()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sub = db.rawQuery("select MIN("+COL3+") AS "+COL3+" from "+TABLE_NAME5+" group by "+COL3,null);
        int max=0;
        for(int i=0;i<sub.getCount();i++)
        {
            while(sub.moveToNext())
            {
                int k = Integer.parseInt(sub.getString(0));
                {
                    if(k>max)
                    {
                        max=k;
                    }
                }
            }
        }
        return max;
    }

    public int resultUpdate()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sub = db.rawQuery("select "+COL2+" from "+TABLE_NAME5,null);
        int i = sub.getCount();
        return i;
    }

    public void deleteAllDetails()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME5);
    }
}
