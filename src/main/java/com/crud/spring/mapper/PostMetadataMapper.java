/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.mapper;

import com.crud.spring.modelo.PostMetadata;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sarit
 */
public class PostMetadataMapper implements RowMapper<PostMetadata> {

    @Override
    public PostMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostMetadata PostMetadata = new PostMetadata();
        PostMetadata.setId_post_metadata(rs.getInt("id_post_metadata"));
        PostMetadata.setClave(rs.getString("clave"));
        PostMetadata.setValor(rs.getString("valor"));
        PostMetadata.setTipo(rs.getString("tipo"));
        PostMetadata.setId_post(rs.getInt("id_post"));
        return PostMetadata;
    }

}
