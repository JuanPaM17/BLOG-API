/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo;

/**
 *
 * @author sarit
 */
public class Post {

    private int id_post;
    private String titulo;
    private String urlImg;
    private String extracto;
    private int id_usuario;
    private int id_categoria;
    private String imgDestacada;
    private String tipo;

    public Post() {
    }

    public Post(int id_post, String titulo, String urlImg, String extracto, int id_usuario, int id_categoria, String imgDestacada, String tipo) {
        this.id_post = id_post;
        this.titulo = titulo;
        this.urlImg = urlImg;
        this.extracto = extracto;
        this.id_usuario = id_usuario;
        this.id_categoria = id_categoria;
        this.imgDestacada = imgDestacada;
        this.tipo = tipo;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getExtracto() {
        return extracto;
    }

    public void setExtracto(String extracto) {
        this.extracto = extracto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getImgDestacada() {
        return imgDestacada;
    }

    public void setImgDestacada(String imgDestacada) {
        this.imgDestacada = imgDestacada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "post{" + "id_post=" + id_post + ", titulo=" + titulo + ", urlImg=" + urlImg + ", extracto=" + extracto + ", id_usuario=" + id_usuario + ", id_categoria=" + id_categoria + ", imgDestacada=" + imgDestacada + ", tipo=" + tipo + '}';
    }

}
