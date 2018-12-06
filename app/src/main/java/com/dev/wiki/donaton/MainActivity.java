package com.dev.wiki.donaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dev.wiki.donaton.DataBase.Personas;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAlvergues(View view){
        intent = new Intent(this,AlberguesActivity.class);
        startActivity(intent);
    }

    public void goDonar(View view){
       intent = new Intent(this,CategoriaActivity.class);
       startActivity(intent);
    }

    public void goPerfil(View view){
        Bundle bundle = new Bundle();
        bundle.putInt(Personas.COLUMN_ID,getIntent().getExtras().getInt(Personas.COLUMN_ID));
        intent = new Intent(this,PerfilActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
