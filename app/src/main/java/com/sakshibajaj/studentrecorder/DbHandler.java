package com.sakshibajaj.studentrecorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DbHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Context context;

    DbHandler(Context context){

        super(context, "student_db", null, 1 );
        this.context = context;
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table student(rno integer primary key ,name text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(int rno, String name){
        ContentValues cv = new ContentValues();
        cv.put("rno", rno);
        cv.put("name",name);
        long rid = db.insert("student", null, cv);

        if(rid<0)
            Toast.makeText(context, "Roll number already exists.", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(context, "Record added", Toast.LENGTH_SHORT).show();
    }

    public String viewStudent()
    {
        Cursor cursor = db.query("student", null, null, null,
                null,null,null);
        StringBuffer sb = new StringBuffer();
        cursor.moveToFirst();
        if(cursor.getCount()>0) {
            do {
                String rno = cursor.getString(0);
                String name = cursor.getString(1);
                sb.append("Roll no:" + rno + "Name: " + name + "\n");
            } while (cursor.moveToNext());
        }    return sb.toString();
    }


    public void updateStudent(int rno, String name) {
        ContentValues cv = new ContentValues();
        cv.put("rno", rno);
        cv.put("name", name);
        long rid = db.update("student", cv,"rno = "+rno,null);

        if(rid<0)
            Toast.makeText(context, "Update unsuccessful", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Record updated", Toast.LENGTH_SHORT).show();

    }

    public void deleteStudent(int rno){
        db.delete("student", "rno = "+ rno,null);
        Toast.makeText(context, "Record deleted", Toast.LENGTH_SHORT).show();
    }
}
