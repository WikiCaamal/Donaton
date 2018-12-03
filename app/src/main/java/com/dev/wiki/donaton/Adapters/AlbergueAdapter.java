package com.dev.wiki.donaton.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.wiki.donaton.Models.Albergue;
import com.dev.wiki.donaton.R;

import java.util.ArrayList;

public class AlbergueAdapter extends BaseAdapter {

    Context context;
    ArrayList<Albergue> listAlbergues = new ArrayList<>();

    public AlbergueAdapter(Context context, ArrayList<Albergue> listAlbergues) {
        this.context = context;
        this.listAlbergues = listAlbergues;
    }

    @Override
    public int getCount() {
        return listAlbergues.size();
    }

    @Override
    public Object getItem(int i) {
        return listAlbergues.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Albergue albergue = (Albergue) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.item_albergue,null);
        ImageView img = view.findViewById(R.id.img_item);
        TextView nombre = view.findViewById(R.id.nombre);
        TextView direccion = view.findViewById(R.id.direccion);
        TextView ubicacion = view.findViewById(R.id.ubicacion);

        //TODO: Agregar la carga de imagen

        nombre.setText(albergue.getNombre());
        direccion.setText(albergue.getDireccion());
        ubicacion.setText(albergue.getUbicacion());

        return view;
    }
}
