package database.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import model.ScanData;

/**
 * Created by User on 10/22/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "historyManager";
    private static final String TABLE_HISTORY = "history";

    private static final String KEY_ID = "id";
    private static final String KEY_DATA = "data";
    private static final String KEY_DATE = "date";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_HISTORY + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DATA + " TEXT,"
                + KEY_DATE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);

        onCreate(db);
    }

    public void addHistory(ScanData scanData){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATA, scanData.getsData());
        values.put(KEY_DATE, scanData.getDate());

        db.insert(TABLE_HISTORY, null, values);
        db.close();
    }

    public List<ScanData> getAllHistory(){
        List<ScanData> allHistory = new ArrayList<ScanData>();

        String query = "SELECT * FROM " + TABLE_HISTORY + " ORDER BY " +
                KEY_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                ScanData scanData = new ScanData();
                scanData.setId(Integer.parseInt(cursor.getString(0)));
                scanData.setsData(cursor.getString(1));
                scanData.setDate(cursor.getString(2));

                allHistory.add(scanData);
            }while(cursor.moveToNext());
        }else{
            ScanData scanData = new ScanData();
            scanData.setsData("Empty");
            scanData.setDate("Empty");

            allHistory.add(scanData);
        }
        return allHistory;
    }

    public void deleteAllHistory(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HISTORY, null, null);
        db.close();
    }

}
