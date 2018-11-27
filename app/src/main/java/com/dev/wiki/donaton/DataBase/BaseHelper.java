package com.dev.wiki.donaton.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {
    String tablePersonas = "CREATE TABLE Personas (Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre text, Apellido text, Usuario text, Correo text, Contrasena text)";
    String tableArticulos = "CREATE TABLE Articulos(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre text)";


    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablePersonas);
        db.execSQL(tableArticulos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
