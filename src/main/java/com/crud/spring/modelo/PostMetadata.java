/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo;

/**
 *
 * @author sarit
 */
public class PostMetadata {

    private int id_post_metadata;
    private String clave;
    private String valor;
    private String tipo;
    private int id_post;

    public PostMetadata(int id_post_metadata, String clave, String valor, String tipo, int id_post) {
        this.id_post_metadata = id_post_metadata;
        this.clave = clave;
        this.valor = valor;
        this.tipo = tipo;
        this.id_post = id_post;
    }

    public PostMetadata() {
    }

    public int getId_post_metadata() {
        return id_post_metadata;
    }

    public void setId_post_metadata(int id_post_metadata) {
        this.id_post_metadata = id_post_metadata;
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

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    @Override
    public String toString() {
        return "PostMetadata{" + "id_post_metadata=" + id_post_metadata + ", clave=" + clave + ", valor=" + valor + ", tipo=" + tipo + ", id_post=" + id_post + '}';
    }

}
