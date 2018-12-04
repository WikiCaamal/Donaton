package com.dev.wiki.donaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAlvergues(View view){
        Intent intent = new Intent(this,AlberguesActivity.class);
        startActivity(intent);
    }

    public void goDonar(View view){
       try {
           Intent intent = new Intent(this,CategoriaActivity.class);
           startActivity(intent);
       }catch (Exception e){
           Log.e("Interrupcion",e.getMessage());
       }
    }
}
