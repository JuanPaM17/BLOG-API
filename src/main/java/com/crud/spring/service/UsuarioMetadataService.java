/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.UsuarioMetadataMapper;
import com.crud.spring.modelo.UsuarioMetadata;
import com.crud.spring.serviceInterfaz.IUsuarioMetadataService;
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
public class UsuarioMetadataService implements IUsuarioMetadataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean guardar(UsuarioMetadata UsuarioMetadata) {
        try {
            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);
            try {
                String sql = String.format("INSERT INTO usuario_metadata (id_usuario,clave,valor,tipo) VALUES ('%d','%s','%s','%s')", UsuarioMetadata.getId_usuario(), UsuarioMetadata.getClave(), UsuarioMetadata.getValor(), UsuarioMetadata.getTipo());
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
    public boolean actualizar(UsuarioMetadata UsuarioMetadata) {
        try {
            String sql = String.format("UPDATE usuario_metadata set tipo='%s',valor='%s',clave='%s',id_usuario='%d' where id_usuario_metadata='%d'", UsuarioMetadata.getTipo(), UsuarioMetadata.getValor(), UsuarioMetadata.getClave(), UsuarioMetadata.getId_usuario(), UsuarioMetadata.getId_usuario_metadata());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<UsuarioMetadata> listar(Pageable pageable) {
        return (ArrayList<UsuarioMetadata>) jdbcTemplate.query("select * from usuario_metadata", new UsuarioMetadataMapper());
    }

    @Override
    public UsuarioMetadata buscarId(int id) {
       Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from usuario_metadata where id_usuario_metadata=?", params, new UsuarioMetadataMapper());
    }

}
