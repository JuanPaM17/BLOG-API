/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.PostMetadataMapper;
import com.crud.spring.modelo.PostMetadata;
import com.crud.spring.serviceInterfaz.IPostMetadataService;
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
public class PostMetadataService implements IPostMetadataService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean guardar(PostMetadata PostMetadata) {
        try {
            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);
            try {
                String sql = String.format("INSERT INTO post_metadata (id_post,clave,valor,tipo) VALUES ('%d','%s','%s','%s')", PostMetadata.getId_post(), PostMetadata.getClave(), PostMetadata.getValor(), PostMetadata.getTipo());
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
    public boolean actualizar(PostMetadata PostMetadata) {
        try {
            String sql = String.format("UPDATE post_metadata set tipo='%s',valor='%s',clave='%s',id_post='%d' where id_post_metadata='%d'", PostMetadata.getTipo(), PostMetadata.getValor(), PostMetadata.getClave(), PostMetadata.getId_post(), PostMetadata.getId_post_metadata());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<PostMetadata> listar(Pageable pageable) {
        return (ArrayList<PostMetadata>) jdbcTemplate.query("select * from post_metadata", new PostMetadataMapper());
    }

    @Override
    public PostMetadata buscarId(int id) {
       Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from post_metadata where id_post_metadata=?", params, new PostMetadataMapper());
    }
    
}
