/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo;

/**
 *
 * @author sarit
 */
public class Permiso {

    private int id_permiso;
    private String nombre;

    public Permiso(int id_permiso, String nombre) {
        this.id_permiso = id_permiso;
        this.nombre = nombre;
    }

    public Permiso() {
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Permiso{" + "id_permiso=" + id_permiso + ", nombre=" + nombre + '}';
    }

}
