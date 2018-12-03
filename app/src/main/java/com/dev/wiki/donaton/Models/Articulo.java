package com.dev.wiki.donaton.Models;

public class Articulo {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String dimenciones;
    private String estado;
    private String categoria;

    public Articulo(Integer id, String nombre, String descripcion, String direccion, String dimenciones, String estado, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.dimenciones = dimenciones;
        this.estado = estado;
        this.categoria = categoria;
    }
    public Articulo(String nombre, String descripcion, String direccion, String dimenciones, String estado, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.dimenciones = dimenciones;
        this.estado = estado;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDimenciones() {
        return dimenciones;
    }

    public void setDimenciones(String dimenciones) {
        this.dimenciones = dimenciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
