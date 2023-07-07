/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.mapper;

import com.crud.spring.modelo.Comentario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sarit
 */
public class ComentarioMapper implements RowMapper<Comentario>{

    @Override
    public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comentario comentario = new Comentario();
        comentario.setId_comentario(rs.getInt("id_comentario"));
        comentario.setComentario(rs.getString("comentario"));
        comentario.setId_post(rs.getInt("id_post"));
        comentario.setId_usuario(rs.getInt("id_usuario"));
        comentario.setRespuesta(rs.getInt("respuesta"));
        return comentario;
    }
    
}
