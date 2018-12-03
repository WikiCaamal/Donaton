package com.dev.wiki.donaton.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dev.wiki.donaton.DataBase.Albergues;
import com.dev.wiki.donaton.DataBase.BaseHelper;
import com.dev.wiki.donaton.Models.Albergue;

import java.util.ArrayList;

public class DaoAlbergue {
    private BaseHelper baseHelper;
    private SQLiteDatabase dbWrite;
    private SQLiteDatabase dbRead;
    private ContentValues registro;
    private ArrayList<Albergue> listAlbergues;
    private Albergue albergue;

    public DaoAlbergue(Context context) {
        this.baseHelper = new BaseHelper(context,"Donaton.db",null,1);
        this.dbWrite = this.baseHelper.getWritableDatabase();
        this.dbRead = this.baseHelper.getReadableDatabase();
    }

    public ContentValues getValuesRegistro(Albergue albergue){
        registro = new ContentValues();
        registro.put(Albergues.COLUMN_NOMBRE,   albergue.getNombre());
        registro.put(Albergues.COLUMN_DIRECCION,albergue.getDireccion());
        registro.put(Albergues.COLUMN_HORARIO,  albergue.getHorario());
        registro.put(Albergues.COLUMN_TELEFONO, albergue.getTelefono());
        registro.put(Albergues.COLUMN_UBICACION,albergue.getUbicacion());
        return registro;
    }

    public ArrayList<Albergue> getAll(){
        listAlbergues = new ArrayList<>();
        try {
            if (dbRead != null){
                Cursor c = dbRead.rawQuery("SELECT * FROM Albergues",null);
                if (c.moveToFirst()){
                    do {
                        albergue = new Albergue(
                                c.getInt(c.getColumnIndex(Albergues.COLUMN_ID)),
                                c.getString(c.getColumnIndex(Albergues.COLUMN_NOMBRE)),
                                c.getString(c.getColumnIndex(Albergues.COLUMN_DIRECCION)),
                                c.getString(c.getColumnIndex(Albergues.COLUMN_HORARIO)),
                                c.getString(c.getColumnIndex(Albergues.COLUMN_TELEFONO)),
                                c.getString(c.getColumnIndex(Albergues.COLUMN_UBICACION))
                        );
                        listAlbergues.add(albergue);
                    }while (c.moveToNext());
                    return listAlbergues;
                }
                else {
                    return null;
                }
            }else {
                return null;
            }
        }catch (Exception e){
            Log.e("Error Get",e.getMessage());
            return null;
        }
    }
    public boolean insert(Albergue albergue){
        try {
            if (dbWrite != null){
                dbWrite.beginTransaction();
                if (dbWrite.insert(Albergues.TABLE_NAME,null,getValuesRegistro(albergue)) != -1){
                    dbWrite.setTransactionSuccessful();
                    return true;
                }
                else {
                    return false;
                }
            }else {
                return false;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
            return false;
        }
        finally {
            dbWrite.endTransaction();
        }
    }
    public boolean update(Albergue albergue){
        try {
            if (dbWrite != null){
                dbWrite.beginTransaction();
                String condicion = Albergues.COLUMN_ID + "= ?";
                String[] args = new String[]{albergue.getId().toString()};
                if (dbWrite.update(Albergues.TABLE_NAME,getValuesRegistro(albergue),condicion,args) != -1){
                    dbWrite.setTransactionSuccessful();
                    return true;
                }else {
                    return false;
                }
            }
            else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
        finally {
            dbWrite.endTransaction();
        }
    }
    public boolean delete(Integer id){
        try {
            if (dbWrite != null){
                dbWrite.beginTransaction();
                String condicion = Albergues.COLUMN_ID + "= ?";
                String[] args = new String[]{id.toString()};
                if (dbWrite.delete(Albergues.TABLE_NAME,condicion,args) != 0){
                    dbWrite.setTransactionSuccessful();
                    return true;
                }else {
                    return false;
                }
            }else{
                return false;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
            return false;
        }
        finally {
            dbWrite.endTransaction();
        }
    }
}
