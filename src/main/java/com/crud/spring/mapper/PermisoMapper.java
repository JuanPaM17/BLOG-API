/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.mapper;

import com.crud.spring.modelo.Permiso;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author sarit
 */
public class PermisoMapper implements RowMapper<Permiso> {

    @Override
    public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
        Permiso permiso = new Permiso();
        permiso.setId_permiso(rs.getInt("id_permiso"));
        permiso.setNombre(rs.getString("nombre"));
        return permiso;
    }

}
