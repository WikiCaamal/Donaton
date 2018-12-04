package com.dev.wiki.donaton.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dev.wiki.donaton.Models.Categoria;
import com.dev.wiki.donaton.R;

import java.util.ArrayList;

public class CategoriaAdapter extends BaseAdapter {

    Context context;
    ArrayList<Categoria> listCategorias;
    public CategoriaAdapter(Context context, ArrayList<Categoria> listCategorias) {

        this.context = context;
        this.listCategorias = listCategorias;
    }


    @Override
    public int getCount() {
        return listCategorias.size();
    }

    @Override
    public Object getItem(int i) {
        return listCategorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Categoria categoria = (Categoria) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item_categoria,null);
        TextView nombre = view.findViewById(R.id.tv_nombre);
        CheckBox selected = view.findViewById(R.id.checkbox_select);

        nombre.setText(categoria.getNombre());
        selected.setChecked(categoria.isSelected());
        return view;
    }
}
