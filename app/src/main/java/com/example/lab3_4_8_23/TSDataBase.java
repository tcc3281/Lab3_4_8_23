package com.example.lab3_4_8_23;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TSDataBase extends SQLiteOpenHelper {
    public static final String TableName="ThiSinhTable";
    public static final String SBD="SBD";
    public static final String HoTen="HoTen";
    public static final String toan="toan";
    public static final String ly="ly";
    public static final String hoa="hoa";


    public TSDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate="Create table if not exists "+TableName+"(" +
                SBD + " Text Primary key, "+
                HoTen + " Text ,"+
                toan + " real,"+
                ly + " real,"+
                hoa + " real)";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+TableName);
        onCreate(db);
    }

    public void addThiSing(ThiSinh thiSinh){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(SBD,thiSinh.getSBD());
        values.put(HoTen,thiSinh.getHoten());
        values.put(toan,thiSinh.getToan());
        values.put(ly,thiSinh.getLy());
        values.put(hoa,thiSinh.getHoa());
        db.insert(TableName,null,values);
        db.close();
    }
    public void deleteThiSinh(ThiSinh thiSinh){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("Delete from "+TableName+" where "+SBD +" = "+ thiSinh.getSBD());

        db.close();
    }
    public List<ThiSinh> getAllThiSing(){
        List<ThiSinh> list=new ArrayList<>();
        String sql="Select * from "+TableName;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                ThiSinh thiSinh=new ThiSinh(cursor.getString(0),cursor.getString(1),cursor.getDouble(2),cursor.getDouble(3),cursor.getDouble(4));
                list.add(thiSinh);
            }
        }
        return list;
    }
}
