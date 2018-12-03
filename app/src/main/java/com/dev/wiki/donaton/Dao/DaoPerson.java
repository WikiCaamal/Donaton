package com.dev.wiki.donaton.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dev.wiki.donaton.DataBase.BaseHelper;
import com.dev.wiki.donaton.DataBase.Personas;
import com.dev.wiki.donaton.Models.Person;

import java.util.ArrayList;

public class DaoPerson {
    private BaseHelper baseHelper;
    private SQLiteDatabase dbWrite;
    private SQLiteDatabase dbRead;
    private ContentValues registro;
    private Person person;

    public DaoPerson(Context context){
        this.baseHelper = new BaseHelper(context,"Donaton.db",null,1);
        this.dbWrite = this.baseHelper.getWritableDatabase();
        this.dbRead = this.baseHelper.getReadableDatabase();
    }

    private ArrayList<Person> listPersons;

    public ArrayList<Person> getAll(){
        listPersons = new ArrayList<>();
        try {
            if (dbRead!=null){
                Cursor c = dbRead.rawQuery("Select * from Personas",null);
                if (c.moveToFirst()){
                    do{
                        person = new Person(
                            c.getInt(c.getColumnIndex(Personas.COLUMN_ID)),
                            c.getString(c.getColumnIndex(Personas.COLUMN_NOMBRE)),
                            c.getString(c.getColumnIndex(Personas.COLUMN_APELLIDO)),
                            c.getString(c.getColumnIndex(Personas.COLUMN_CORREO)),
                            c.getString(c.getColumnIndex(Personas.COLUMN_USUARIO)),
                            c.getString(c.getColumnIndex(Personas.COLUMN_CONTRASENA))
                        );
                        listPersons.add(person);
                    }while (c.moveToNext());
                }
                return  listPersons;
            }else {return null;}
        }catch (Exception e){
            return null;
        }
    }

    public ContentValues getValuesRegistro(Person person){
        registro = new ContentValues();
        registro.put(Personas.COLUMN_NOMBRE,    person.getName());
        registro.put(Personas.COLUMN_APELLIDO,  person.getLastName());
        registro.put(Personas.COLUMN_CORREO,    person.getEmail());
        registro.put(Personas.COLUMN_USUARIO,   person.getUser());
        registro.put(Personas.COLUMN_CONTRASENA,person.getPassword());
        return registro;
    }

    public boolean insert(Person person){
        try {
            if (dbWrite!=null){
                if (dbWrite.insert(Personas.TABLE_NAME,null,getValuesRegistro(person)) != -1){
                    return true;
                }
                else {
                    return false;
                }
            }else {return false;}
        }catch (Exception e){
            Log.e("SQLite_Error",e.getMessage());
            return false;
        }
    }

    public boolean update(Person person){

        try {
            if (dbWrite != null){
                String condicion = Personas.COLUMN_ID + "= ?";
                String[] args = new String[]{person.getId().toString()};
                if (dbWrite.update(Personas.TABLE_NAME,getValuesRegistro(person),condicion,args) != -1){
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
    }

    public boolean delete(Integer id){
        try {
            if (dbWrite != null){
                String condicion = Personas.COLUMN_ID + " = ?";
                String[] args = new String[]{id.toString()};
                if (dbWrite.delete(Personas.TABLE_NAME,condicion,args) != 0){
                    return true;
                }
                else {
                    return false;
                }
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

}
