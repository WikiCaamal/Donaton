package com.dev.wiki.donaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.dev.wiki.donaton.Adapters.CategoriaAdapter;
import com.dev.wiki.donaton.Models.Categoria;

import java.util.ArrayList;

public class CategoriaActivity extends AppCompatActivity {
    ListView listCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        listCategoria = findViewById(R.id.list_categorias);

        CategoriaAdapter adapter = new CategoriaAdapter(this,listCategorias());
        listCategoria.setAdapter(adapter);
    }


    //TODO: Datos de pueba

    public ArrayList<Categoria> listCategorias(){
        ArrayList<Categoria>list = new ArrayList<>();
        list.add(new Categoria("Ropa",false));
        list.add(new Categoria("Zapatos",false));
        list.add(new Categoria("Higiene",false));
        list.add(new Categoria("Comida",false));
        list.add(new Categoria("Libros",false));
        list.add(new Categoria("Medicina",false));
        return list;
    }
}
