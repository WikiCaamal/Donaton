package com.dev.wiki.donaton.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.dev.wiki.donaton.Models.Albergue;

public class BaseHelper extends SQLiteOpenHelper {
    
    private String tablaPersonas = "CREATE TABLE "+Personas.TABLE_NAME +
            "(" +
                Personas.COLUMN_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Personas.COLUMN_NOMBRE      + " TEXT, " +
                Personas.COLUMN_APELLIDO    + " TEXT, " +
                Personas.COLUMN_USUARIO     + " TEXT, " +
                Personas.COLUMN_CORREO      + " TEXT, " +
                Personas.COLUMN_CONTRASENA  + " TEXT" +
            ")";

    private String tablaArticulos = "CREATE TABLE "+Articulos.TABLE_NAME +
            "(" +
                Articulos.COLUMN_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Articulos.COLUMN_NOMBRE         + " TEXT," +
                Articulos.COLUMN_DIRECCION      + " TEXT," +
                Articulos.COLUMN_DIMENCIONES    + " TEXT," +
                Articulos.COLUMN_DESCRIPCION    + " TEXT," +
                Articulos.COLUMN_ESTADO         + " TEXT," +
                Articulos.COLUMN_CATEGORIA      + " TEXT" +
            ")";

    private String tablaAlbergues = "CREATE TABLE "+Albergues.TABLE_NAME +
            "("+
                Albergues.COLUMN_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Albergues.COLUMN_NOMBRE     + " TEXT," +
                Albergues.COLUMN_DIRECCION  + " TEXT," +
                Albergues.COLUMN_HORARIO    + " TEXT," +
                Albergues.COLUMN_TELEFONO   + " TEXT," +
                Albergues.COLUMN_UBICACION  + " TEXT" +
            ")";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaPersonas);
        db.execSQL(tablaArticulos);
        db.execSQL(tablaAlbergues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
