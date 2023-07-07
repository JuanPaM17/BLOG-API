/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.ComentarioMapper;
import com.crud.spring.modelo.Comentario;
import com.crud.spring.serviceInterfaz.IComentarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
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
public class ComentarioService implements IComentarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean guardar(Comentario comentario) {
        try {
            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);
            try {
                String sql;
                if (comentario.getRespuesta() != 0) {
                    sql = String.format("INSERT INTO comentario (comentario, id_post,id_usuario,respuesta) VALUES ('%s', '%d','%d','%d')", comentario.getComentario(), comentario.getId_post(), comentario.getId_usuario(), comentario.getRespuesta());
                } else {
                    sql = String.format("INSERT INTO comentario (comentario, id_post,id_usuario) VALUES ('%s', '%d','%d')", comentario.getComentario(), comentario.getId_post(), comentario.getId_usuario());
                }
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
                throw new NullPointerException(e.getMessage());
            }
        } catch (NullPointerException | TransactionException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @Override
    public boolean actualizar(Comentario comentario) {
        try {
            String sql = String.format("UPDATE comentario set comentario='%s' where id_comentario='%d'", comentario.getComentario(), comentario.getId_comentario());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<Comentario> listar(SpringDataWebProperties.Pageable pageable) {
        return (ArrayList<Comentario>) jdbcTemplate.query("select * from comentario", new ComentarioMapper());
    }

    @Override
    public Comentario buscarId(int id) {
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from comentario where id_comentario=?", params, new ComentarioMapper());
    }

    @Override
    public boolean eliminarId(int id) {
        try {
            String sql = String.format("DELETE FROM comentario where id_comentario='%d'", id);
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al eliminar");
        }
    }

}
