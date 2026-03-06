package com.example.baratheonx;

public class BaratheonMenuCafes {

    int imagen;
    String titulo;
    String descripcion;

    public BaratheonMenuCafes(int imagen, String titulo, String descripcion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}