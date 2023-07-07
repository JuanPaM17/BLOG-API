/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo;

/**
 *
 * @author sarit
 */
public class UsuarioMetadata {

    private int id_usuario_metadata;
    private String clave;
    private String valor;
    private String tipo;
    private int id_usuario;

    public UsuarioMetadata(int id_usuario_metadata, String clave, String valor, String tipo, int id_usuario) {
        this.id_usuario_metadata = id_usuario_metadata;
        this.clave = clave;
        this.valor = valor;
        this.tipo = tipo;
        this.id_usuario = id_usuario;
    }

    public UsuarioMetadata() {
    }

    public int getId_usuario_metadata() {
        return id_usuario_metadata;
    }

    public void setId_usuario_metadata(int id_usuario_metadata) {
        this.id_usuario_metadata = id_usuario_metadata;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "UsuarioMetadata{" + "id_usuario_metadata=" + id_usuario_metadata + ", clave=" + clave + ", valor=" + valor + ", tipo=" + tipo + ", id_usuario=" + id_usuario + '}';
    }
    
}
