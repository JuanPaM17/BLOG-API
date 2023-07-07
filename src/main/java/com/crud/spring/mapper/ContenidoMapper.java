/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.mapper;

import com.crud.spring.modelo.Contenido;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sarit
 */
public class ContenidoMapper implements RowMapper<Contenido> {

    @Override
    public Contenido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contenido contenido = new Contenido();
        contenido.setId_contenido(rs.getInt("id_contenido"));
        contenido.setTipo(rs.getString("tipo"));
        contenido.setContenido(rs.getString("contenido"));
        contenido.setId_post(rs.getInt("id_post"));
        return contenido;
    }

}
