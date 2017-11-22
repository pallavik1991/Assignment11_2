package com.example.akaash.assignment11_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKAASH on 22-11-2017.
 */

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(Context context) {
        super(context, "ProductDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query="create table product(p_name text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table product if exists");
    }

    public void insert()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("p_name","Notebook");
        db.insert("product",null,values);
        values.put("p_name","Pencil");
        db.insert("product",null,values);
        values.put("p_name","Pen");
        db.insert("product",null,values);
        values.put("p_name","Sharpner");
        db.insert("product",null,values);

    }

    public List<String> display()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        List<String> pnames=new ArrayList<String>();
        String q="select * from product";
        Cursor cursor=db.rawQuery(q,null);
        if(cursor.moveToFirst())
        {
            do{
                String pname;
                pname=cursor.getString(0);
                pnames.add(pname);
            }while (cursor.moveToNext());
        }
        return pnames;
    }
}
