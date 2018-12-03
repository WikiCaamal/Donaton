package com.dev.wiki.donaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dev.wiki.donaton.Adapters.AlbergueAdapter;
import com.dev.wiki.donaton.Models.Albergue;

import java.util.ArrayList;

public class AlberguesActivity extends AppCompatActivity {
    private ListView listAlbergue;
    private Albergue albergue;
    private ArrayList<Albergue> listAlbergues;

    private void initComponents(){
        listAlbergue = findViewById(R.id.list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albergues);
        initComponents();

        AlbergueAdapter adapter = new AlbergueAdapter(this,testData());
        listAlbergue.setAdapter(adapter);
    }

    //TODO: Eliminar despues de las pruebas
    public ArrayList<Albergue> testData(){
        listAlbergues = new ArrayList<>();
        listAlbergues.add(new Albergue( "Albegue 1","C.00 x 00 y 00", "9:00 am - 2:00 pm", "999-369-8524", "Tekax"));
        listAlbergues.add(new Albergue( "Albegue 2","C.00 x 00 y 00", "8:00 am - 4:00 pm", "999-369-8524", "Oxkutzcab"));
        listAlbergues.add(new Albergue( "Albegue 3","C.00 x 00 y 00", "7:00 am - 5:00 pm", "999-369-8524", "Merida"));
        listAlbergues.add(new Albergue( "Albegue 4","C.00 x 00 y 00", "9:30 am - 7:00 pm", "999-369-8524", "Uman"));
        listAlbergues.add(new Albergue( "Albegue 5","C.00 x 00 y 00", "10:00 am - 10:00 pm", "999-369-8524", "Akil"));
        return listAlbergues;
    }


}
