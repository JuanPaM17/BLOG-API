/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.CategoriaMapper;
import com.crud.spring.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.crud.spring.serviceInterfaz.ICategoriaService;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.dao.DataAccessException;
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
public class CategoriaService implements ICategoriaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean guardar(Categoria categoria) {
        try {
            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);
            try {
                String sql = String.format("INSERT INTO categoria (nombre, descripcion) VALUES ('%s', '%s')", categoria.getNombre(), categoria.getDescripcion());
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
    public boolean actualizar(Categoria categoria) {
        try {
            String sql = String.format("UPDATE categoria set nombre='%s',descripcion='%s' where id_categoria='%d'", categoria.getNombre(), categoria.getDescripcion(), categoria.getId_categoria());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<Categoria> listar(Pageable pageable) {
        return (ArrayList<Categoria>) jdbcTemplate.query("select * from categoria", new CategoriaMapper());
    }

    @Override
    public Categoria buscarId(int id) {
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from categoria where id_categoria=?", params, new CategoriaMapper());
    }

    @Override
    public boolean eliminarId(int id) {
        try {
            String sql = String.format("DELETE FROM categoria where id_categoria='%d'", id);
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al eliminar");
        }
    }

}
