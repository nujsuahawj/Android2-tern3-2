package com.bmp.sqliteapp;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.Currency;

import androidx.annotation.Nullable;

public class myDatabase extends SQLiteOpenHelper {
    private static final String dbname="db1";
    private static final int dbversion=1;
    String createtable="create table tbbook(" +
            "bid TEXT(20) PRIMARY KEY AUTOINCREMENT," +
            "bname TEXT(50)," +
            "price INTEGER," +
            "page INTEGER);";


    public myDatabase(@Nullable Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createtable);

    }
    public long UpdateData(){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql="Update tbbook set bname=?,price=?,page =? where bid=?";

            return 1;
        }catch (Exception ex){
            return -1;
        }
    }
    public long InsertData(String bid,String bname,String price,String page){
        try {
            SQLiteDatabase db =this.getWritableDatabase();

            String sql="Insert into tbbook values(?,?,?)";
            SQLiteStatement stm =db.compileStatement(sql);
            stm.bindString(1,bid);
            stm.bindString(2,bname);
            stm.bindString(3,price);
            stm.bindString(4,page);
           long r =stm.executeInsert();
           db.close();
           return r;
        }catch (Exception ex){
            return -1;
        }
    }

    public long EditData(String bid,String bname,String bprice,String bpage){
        try {
            SQLiteDatabase db =this.getWritableDatabase();
            String sql="Update tbbook set bname=?,price=?,page=? where bid=?";
            SQLiteStatement stm = db.compileStatement(sql);
            stm.bindString(1,bname);
            stm.bindString(2,bprice);
            stm.bindString(3,bpage);
            stm.bindString(4,bid);

           long r= stm.executeUpdateDelete();
            db.close();
            return r;


        }catch (Exception ex){
            return -1;
        }

    }
    public Cursor SelectData(String bid){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String sql="select * from tbbook where bid='"+bid+"'";

            Cursor cur = db.rawQuery(sql,null);

            return cur;

        }catch (Exception ex){
            return null;
        }

    }
    public Cursor SelectAllData(){
        try {
            SQLiteDatabase db =this.getReadableDatabase();
            String sql="Select * from tbbook";
            Cursor cursor =db.rawQuery(sql,null);
            return cursor;
        }catch (Exception ex){
            return null;
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public long InsertData(String toString, String toString1, String toString2) {
//    }
}
