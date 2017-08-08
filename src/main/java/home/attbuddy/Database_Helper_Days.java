package home.attbuddy;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_Helper_Days extends SQLiteOpenHelper {

    public static final String DATABASE_NAME4 = "days.db";
    public static final String TABLE_NAME4 = "names";
    public static final String COL1 = "ID";
    public static final String COL2 = "MONDAY";
    public static final String COL3 = "TUESDAY";
    public static final String COL4 = "WEDNESDAY";
    public static final String COL5 = "THURSDAY";
    public static final String COL6 = "FRIDAY";
    public static final String COL7 = "SATURDAY";


    public Database_Helper_Days(Context context) {
        super(context, DATABASE_NAME4, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME4 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,MONDAY INTEGER,TUESDAY INTEGER,WEDNESDAY INTEGER,THURSDAY INTEGER,FRIDAY INTEGER,SATURDAY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        onCreate(db);
    }

    public void deleteAllDetails()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME4);
    }

    public void insertID(int mon_id,int tue_id,int wed_id,int thu_id,int fri_id,int sat_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,mon_id);
        contentValues.put(COL3,tue_id);
        contentValues.put(COL4,wed_id);
        contentValues.put(COL5,thu_id);
        contentValues.put(COL6,fri_id);
        contentValues.put(COL7,sat_id);
        db.insert(TABLE_NAME4,null,contentValues);
    }

    public Cursor getID()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query2 = "select * from "+TABLE_NAME4;
        Cursor param2 = db.rawQuery(query2,null);
        return param2;
    }
}