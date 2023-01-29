package com.example.eneskavusanfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {

    private Context context;
    private static final String Database_ismi = "ailerehberi.db";
    private static final int version=1;
    private static final String TABLO_ISMI = "REHBER";
    private static final String SATIR_ID = "_id";
    private static final String ISIM = "isim";
    private static final String TELNO = "telno";
    private static final String AKRABALIK = "akraba";


    public SQLite(@Nullable Context context) {
        super(context, Database_ismi, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String yaratRehber = "CREATE TABLE " + TABLO_ISMI + " (" + SATIR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  ISIM + " TEXT , " +  TELNO + " TEXT , " + AKRABALIK + " TEXT);";
        sqLiteDatabase.execSQL(yaratRehber);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLO_ISMI);
        onCreate(sqLiteDatabase);
    }

    void rehberekle(String isim, String telno,String akraba){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ISIM, isim);
        cv.put(TELNO, telno);
        cv.put(AKRABALIK, akraba);
        db.insert(TABLO_ISMI,null,cv);
    }

    Cursor rehbergetir(){
        String query= "SELECT * FROM " + TABLO_ISMI;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=null;
        if (db != null){
            c=db.rawQuery(query,null);
        }

        return c;
    }

    void rehberduzenle(int idb,String isim, String telno){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(ISIM ,isim);
        cv.put(TELNO ,telno);


        db.update(TABLO_ISMI,cv,"_id=?",new String[]{idb+""});
    }

    void rehbersil(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLO_ISMI, "_id=?",new String[]{id});
    }

}
