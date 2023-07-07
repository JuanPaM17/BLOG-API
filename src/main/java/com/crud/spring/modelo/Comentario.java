/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo;

/**
 *
 * @author sarit
 */
public class Comentario {

    private int id_comentario;
    private String comentario;
    private int id_post;
    private int id_usuario;
    private int respuesta;

    public Comentario(int id_comentario, String comentario, int id_post, int id_usuario, int respuesta) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.id_post = id_post;
        this.id_usuario = id_usuario;
        this.respuesta = respuesta;
    }

    public Comentario() {
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id_comentario=" + id_comentario + ", comentario=" + comentario + ", id_post=" + id_post + ", id_usuario=" + id_usuario + ", respuesta=" + respuesta + '}';
    }

}
