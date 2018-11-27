package com.dev.wiki.donaton.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dev.wiki.donaton.DataBase.BaseHelper;
import com.dev.wiki.donaton.Models.Person;

import java.util.ArrayList;

public class DaoPerson {
    private BaseHelper baseHelper;
    private SQLiteDatabase dbWrite;
    private SQLiteDatabase dbRead;
    private Context context;
    private ContentValues registro;
    private String table = "Personas";
    private Person person;

    public DaoPerson(Context context){
        this.context = context;
        this.baseHelper = new BaseHelper(context,"Donaton.db",null,1);
        this.dbWrite = this.baseHelper.getWritableDatabase();
        this.dbRead = this.baseHelper.getReadableDatabase();
    }

    private ArrayList<Person> listPersons = new ArrayList<>();

    public ArrayList<Person> getAll(){
        try {

            if (dbRead!=null){
                Cursor persons = dbRead.rawQuery("Select * from Personas",null);
                int count = persons.getCount();
                int index = 0;
                String[] arreglo = new String[count];
                if (persons.moveToFirst()){
                    do{
                        person = new Person(
                                persons.getInt(0),
                                persons.getString(1),
                                persons.getString(2),
                                persons.getString(3),
                                persons.getString(4),
                                persons.getString(5)
                        );
                    }while (persons.moveToNext());
                }
                return  listPersons;
            }else {return null;}
        }catch (Exception e){
            return null;
        }
    }

    public boolean insert(Person person){
        try {
            if (dbWrite!=null){
                registro = new ContentValues();
                registro.put("Nombre",person.getName());
                registro.put("Apellido",person.getLastName());
                registro.put("Usuario",person.getUser());
                registro.put("Contrasena",person.getPassword());

                long result = dbWrite.insert(table,null,registro);
                if (result != 0){
                    return true;
                }
                else {
                    return false;
                }
            }else {return false;}
        }catch (Exception e){
            return false;
        }
    }

    public boolean update(Person person){
        return true;
    }

    public boolean delete(Integer id){
        return true;
    }

}
