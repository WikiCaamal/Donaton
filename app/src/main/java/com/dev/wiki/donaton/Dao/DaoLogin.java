package com.dev.wiki.donaton.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dev.wiki.donaton.DataBase.BaseHelper;
import com.dev.wiki.donaton.Models.Person;

public class DaoLogin {
    private BaseHelper baseHelper;
    private SQLiteDatabase dbRead;
    private Context context;


    public DaoLogin(Context context){
        this.context = context;
        this.baseHelper = new BaseHelper(context,"Donaton.db",null,1);
        this.dbRead = this.baseHelper.getReadableDatabase();
    }

    public boolean validUser(String user, String password){
        try {
            if (dbRead!=null){
               String query = "Select * from Personas where Usuario ='"+user+"' and Contrasena='"+password+"'";
                Cursor persons = dbRead.rawQuery(query,null);
                //Cursor persons = dbRead.rawQuery("Select * from Personas",null);
               // Log.i("Dato",persons.getString(3));
                int count = persons.getCount();
                if (count>0){
                    return true;
                }
                else {
                    return false;
                }
            }else {return false;}
        }catch (Exception e){
            Log.e("Error",e.getMessage());
            return false;
        }
    }
}
