package com.example.baratheonx;

public class BaratheonMenuPizza {

    int imagen;
    String titulo;
    String descripcion;

    public BaratheonMenuPizza(int imagen, String titulo, String descripcion) {
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