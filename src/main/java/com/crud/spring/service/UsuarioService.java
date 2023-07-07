/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.UsuarioMapper;
import com.crud.spring.modelo.Usuario;
import com.crud.spring.serviceInterfaz.IUsuarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author sarit
 */
@Repository
public class UsuarioService implements IUsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean guardar(Usuario Usuario) {
        try {
            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);
            try {
                String sql = String.format("INSERT INTO usuario (nombre,apellido,contrasena,correo,id_grupo) VALUES ('%s','%s','%s','%s','%d')", Usuario.getNombre(), Usuario.getApellido(), Usuario.getContrasena(), Usuario.getCorreo(), Usuario.getId_grupo());
                int rowsAffected = jdbcTemplate.update(sql);
                if (rowsAffected > 0) {
                    transactionManager.commit(status);
                    return true;
                } else {
                    transactionManager.rollback(status);
                    return false;
                }
            } catch (DataAccessException | TransactionException e) {
                transactionManager.rollback(status);
                throw new NullPointerException("Error al insertar");
            }
        } catch (NullPointerException | TransactionException ex) {
            throw new NullPointerException("Error al iniciar la transacción");
        }
    }

    @Override
    public boolean actualizar(Usuario Usuario) {
        try {
            String sql = String.format("UPDATE usuario set nombre='%s',apellido='%s',contrasena='%s',correo='%s',id_grupo='%d' where id_usuario='%d'", Usuario.getNombre(), Usuario.getApellido(), Usuario.getContrasena(), Usuario.getCorreo(), Usuario.getId_grupo(), Usuario.getId_usuario());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<Usuario> listar(Pageable pageable) {
        return (ArrayList<Usuario>) jdbcTemplate.query("select * from usuario", new UsuarioMapper());
    }

    @Override
    public Usuario buscarId(int id) {
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from usuario where id_usuario=?", params, new UsuarioMapper());
    }

    @Override
    public boolean eliminarId(int id) {
        try {
            String sql = String.format("DELETE FROM usuario where id_usuario='%d'", id);
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Usuario inicioSesion(String correo) {
        Object[] params = new Object[]{correo};
        return jdbcTemplate.queryForObject("select * from usuario where correo=?", params, new UsuarioMapper());
    }

}
