package com.dev.wiki.donaton.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dev.wiki.donaton.DataBase.BaseHelper;
import com.dev.wiki.donaton.DataBase.Personas;

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
                String query = "SELECT * FROM "+Personas.TABLE_NAME + " WHERE Usuario = ? and Contrasena = ?";
                String[] args = {user,password};
                Cursor persons = dbRead.rawQuery(query,args);

                int count = persons.getCount();

                if (count>0){
                    return true;
                }
                else {
                    return false;
                }
            }else {return false;}
        }catch (Exception e){
            Log.e("Message",e.getMessage());
            return false;
        }
    }
}
