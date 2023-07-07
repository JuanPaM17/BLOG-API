/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo;

/**
 *
 * @author sarit
 */
public class Contenido {

    private int id_contenido;
    private String tipo;
    private String contenido;
    private int id_post;

    public Contenido() {
    }

    public Contenido(int id_contenido, String tipo, String contenido, int id_post) {
        this.id_contenido = id_contenido;
        this.tipo = tipo;
        this.contenido = contenido;
        this.id_post = id_post;
    }

    public int getId_contenido() {
        return id_contenido;
    }

    public void setId_contenido(int id_contenido) {
        this.id_contenido = id_contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    @Override
    public String toString() {
        return "Contenido{" + "id_contenido=" + id_contenido + ", tipo=" + tipo + ", contenido=" + contenido + ", id_post=" + id_post + '}';
    }
    
}
