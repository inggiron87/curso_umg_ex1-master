package com.umg.curso.clases;

/**
 * Created by IT DASA on 28/06/2017.
 */
public class Deportista {
    private String Nombre;
    private int Edad;

    public Deportista(String nombre, int edad) {
        Nombre = nombre;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}

