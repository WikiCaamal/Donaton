package com.dev.wiki.donaton.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dev.wiki.donaton.DataBase.Articulos;
import com.dev.wiki.donaton.DataBase.BaseHelper;
import com.dev.wiki.donaton.Models.Articulo;

import java.util.ArrayList;

public class DaoArticulo {
    private BaseHelper baseHelper;
    private SQLiteDatabase dbWrite;
    private SQLiteDatabase dbRead;
    private ContentValues registro;
    private ArrayList<Articulo> listArticulos;
    private Articulo articulo;

    public DaoArticulo(Context context) {
        this.baseHelper = new BaseHelper(context,"Donaton.db",null,1);
        this.dbWrite = this.baseHelper.getWritableDatabase();
        this.dbRead = this.baseHelper.getReadableDatabase();
    }

    public ContentValues getValuesRegistro(Articulo articulo){
        registro = new ContentValues();
        registro.put(Articulos.COLUMN_NOMBRE,   articulo.getNombre());
        registro.put(Articulos.COLUMN_DIRECCION,articulo.getDireccion());
        registro.put(Articulos.COLUMN_DESCRIPCION,  articulo.getDescripcion());
        registro.put(Articulos.COLUMN_DIMENCIONES, articulo.getDimenciones());
        registro.put(Articulos.COLUMN_CATEGORIA,articulo.getCategoria());
        registro.put(Articulos.COLUMN_ESTADO,articulo.getEstado());
        return registro;
    }

    public ArrayList<Articulo> getAll(){
        listArticulos = new ArrayList<>();
        try {
            if (dbRead != null){
                Cursor c = dbRead.rawQuery("SELECT * FROM Alticulos",null);
                if (c.moveToFirst()){
                    do {
                        articulo = new Articulo(
                                c.getInt(c.getColumnIndex(Articulos.COLUMN_ID)),
                                c.getString(c.getColumnIndex(Articulos.COLUMN_NOMBRE)),
                                c.getString(c.getColumnIndex(Articulos.COLUMN_DESCRIPCION)),
                                c.getString(c.getColumnIndex(Articulos.COLUMN_DIRECCION)),
                                c.getString(c.getColumnIndex(Articulos.COLUMN_DIMENCIONES)),
                                c.getString(c.getColumnIndex(Articulos.COLUMN_ESTADO)),
                                c.getString(c.getColumnIndex(Articulos.COLUMN_CATEGORIA))
                        );
                        listArticulos.add(articulo);
                    }while (c.moveToNext());
                    return listArticulos;
                }
                else {
                    return listArticulos;
                }
            }else {
                return null;
            }
        }catch (Exception e){
            Log.e("Error Get",e.getMessage());
            return null;
        }
    }
    public boolean insert(Articulos articulos){
        try {
            if (dbWrite != null){
                dbWrite.beginTransaction();
                if (dbWrite.insert(Articulos.TABLE_NAME,null,getValuesRegistro(articulo)) != -1){
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
    public boolean update(Articulo articulo){
        try {
            if (dbWrite != null){
                dbWrite.beginTransaction();
                String condicion = Articulos.COLUMN_ID + "= ?";
                String[] args = new String[]{articulo.getId().toString()};
                if (dbWrite.update(Articulos.TABLE_NAME,getValuesRegistro(articulo),condicion,args) != -1){
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
                String condicion = Articulos.COLUMN_ID + "= ?";
                String[] args = new String[]{id.toString()};
                if (dbWrite.delete(Articulos.TABLE_NAME,condicion,args) != 0){
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
