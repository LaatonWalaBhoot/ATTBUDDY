package home.attbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aishwarya on 7/26/2016.
 */
public class Database_Helper_Lectures extends SQLiteOpenHelper {

    public static final String DATABASE_NAME2 = "lectures.db";
    public static final String TABLE_NAME2 = "details";
    public static final String COL1 = "ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "SUBJECT";
    public static final String COL4 = "FACULTY";
    public static final String COL5 = "LOCATION";
    public static final String COL6 = "SERIAL";

    public Database_Helper_Lectures(Context context) {
        super(context, DATABASE_NAME2,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME2 + "(ID INTEGER,TITLE TEXT,SUBJECT TEXT,FACULTY TEXT,LOCATION TEXT,SERIAL INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        onCreate(db);
    }

    public void insertDetails(String ID,String title,String subject,String faculty,String location)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,ID);
        contentValues.put(COL2,title);
        contentValues.put(COL3,subject);
        contentValues.put(COL4,faculty);
        contentValues.put(COL5,location);
        db.insert(TABLE_NAME2,null,contentValues);
    }


    public void updateDetails(String sid,String title,String subject,String faculty,String location)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,sid);
        contentValues.put(COL2,title);
        contentValues.put(COL3,subject);
        contentValues.put(COL4,faculty);
        contentValues.put(COL5,location);
        db.update(TABLE_NAME2,contentValues,"id=?",new String[] {sid});
    }

    public Cursor getDetailsbyTitle(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+ TABLE_NAME2 + " where "+COL2+"=?";
        Cursor get = db.rawQuery(query,new String[] {title});
        return get;
    }

    public Cursor getAllData(String sid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor ins = db.rawQuery("select * from "+ TABLE_NAME2 + " where ID= "+sid,null);
        return ins;
    }


    public void deleteAllDetails()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME2);
    }

    public void deleteDetails(String sid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME2 + " where ID= "+sid);
    }

    public Cursor getSubjectsTitle()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sub = db.rawQuery("select MIN("+COL2+") AS "+COL2+" from "+TABLE_NAME2+" group by "+COL2,null);
        return sub;
    }
    public Cursor getSubjectsName()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sub_full = db.rawQuery("select MIN("+COL3+") AS "+COL3+" from "+TABLE_NAME2+" group by "+COL3,null);
        return sub_full;
    }
    public Cursor setTitle(String sid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor set = db.rawQuery("select "+COL2+" from "+TABLE_NAME2+" where ID= "+sid,null);
        return set;
    }
    public int weekCount()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor param = db.rawQuery("select "+COL2+" from "+TABLE_NAME2,null);
        int count=0;
        while(param.moveToNext())
        {
            if(param.getString(0).length()>0)
            {
                count++;
            }
        }
        return count;
    }

    public Cursor all_ID()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor param1 = db.rawQuery("select "+COL1+" from "+TABLE_NAME2,null);
        return param1;
    }

   public Cursor sub_ID(String title)
   {
       SQLiteDatabase db = this.getWritableDatabase();
       String query1 = "select "+COL1+" from "+TABLE_NAME2+" where "+COL2+"=?";
       Cursor param1 = db.rawQuery(query1,new String[] {title});
       return param1;
   }

}
