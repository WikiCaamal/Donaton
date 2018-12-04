package com.dev.wiki.donaton.Models;

import android.media.Image;

public class Categoria {

    private String image;
    private String nombre;

    public Categoria(String nombre, boolean selected) {
        this.nombre = nombre;
        this.selected = selected;
    }

    private boolean selected;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
