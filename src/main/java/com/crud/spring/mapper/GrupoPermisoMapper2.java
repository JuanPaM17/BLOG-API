/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.mapper;

import com.crud.spring.modelo.GrupoPermiso;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sarit
 */
public class GrupoPermisoMapper2 implements RowMapper<GrupoPermiso> {

    @Override
    public GrupoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
        GrupoPermiso grupoPermiso = new GrupoPermiso();
        grupoPermiso.setId_grupo_permiso(rs.getInt("id_grupo_permiso"));
        grupoPermiso.setNombre_permiso(rs.getString("nombre"));
        return grupoPermiso;
    }

}
