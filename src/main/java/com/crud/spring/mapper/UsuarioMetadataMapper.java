/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.mapper;

import com.crud.spring.modelo.UsuarioMetadata;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sarit
 */
public class UsuarioMetadataMapper implements RowMapper<UsuarioMetadata> {

    @Override
    public UsuarioMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
        usuarioMetadata.setId_usuario_metadata(rs.getInt("id_usuario_metadata"));
        usuarioMetadata.setId_usuario(rs.getInt("id_usuario"));
        usuarioMetadata.setClave(rs.getString("clave"));
        usuarioMetadata.setValor(rs.getString("valor"));
        usuarioMetadata.setTipo(rs.getString("tipo"));
        return usuarioMetadata;
    }

}
