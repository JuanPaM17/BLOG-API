/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo;

/**
 *
 * @author sarit
 */
public class GrupoPermiso {

    private int id_grupo_permiso;
    private int id_permiso;
    private int id_grupo;
    private String nombre_permiso;

    public GrupoPermiso() {
    }

    public GrupoPermiso(int id_grupo_permiso, int id_permiso, int id_grupo) {
        this.id_grupo_permiso = id_grupo_permiso;
        this.id_permiso = id_permiso;
        this.id_grupo = id_grupo;
    }

    public String getNombre_permiso() {
        return nombre_permiso;
    }

    public void setNombre_permiso(String nombre_permiso) {
        this.nombre_permiso = nombre_permiso;
    }
    
    public int getId_grupo_permiso() {
        return id_grupo_permiso;
    }

    public void setId_grupo_permiso(int id_grupo_permiso) {
        this.id_grupo_permiso = id_grupo_permiso;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    @Override
    public String toString() {
        return "GrupoPermiso{" + "id_grupo_permiso=" + id_grupo_permiso + ", id_permiso=" + id_permiso + ", id_grupo=" + id_grupo + '}';
    }

}
