package com.dev.wiki.donaton.Dao;

import com.dev.wiki.donaton.Models.Person;

import java.util.ArrayList;

public class DaoPerson {

    private ArrayList<Person> listPersons = new ArrayList<>();

    public ArrayList<Person> getAll(){
        return null;
    }

    public boolean insert(Person person){
       return true;
    }

    public boolean update(Person person){
        return true;
    }

    public boolean delete(Integer id){
        return true;
    }

}
