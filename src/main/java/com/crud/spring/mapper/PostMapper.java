/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.mapper;

import com.crud.spring.modelo.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sarit
 */
public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId_post(rs.getInt("id_post"));
        post.setTitulo(rs.getString("titulo"));
        post.setUrlImg(rs.getString("url_img"));
        post.setExtracto(rs.getString("extracto"));
        post.setId_usuario(rs.getInt("id_usuario"));
        post.setId_categoria(rs.getInt("id_categoria"));
        post.setImgDestacada(rs.getString("img_destacada"));
        post.setTipo(rs.getString("titulo"));
        return post;
    }

}
