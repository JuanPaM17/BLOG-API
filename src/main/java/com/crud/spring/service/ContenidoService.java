/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.ContenidoMapper;
import com.crud.spring.modelo.Contenido;
import com.crud.spring.serviceInterfaz.IContenidoService;
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
public class ContenidoService implements IContenidoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean guardar(Contenido Contenido) {
        try {
            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);

            try {
                String sql = String.format("INSERT INTO contenido (tipo, contenido,id_post) VALUES ('%s', '%s','%d')", Contenido.getTipo(), Contenido.getContenido(), Contenido.getId_post());
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
    public boolean actualizar(Contenido Contenido) {
        try {
            String sql = String.format("UPDATE contenido set tipo='%s',contenido='%s' where id_contenido='%d'", Contenido.getTipo(), Contenido.getContenido(), Contenido.getId_contenido());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<Contenido> listar(SpringDataWebProperties.Pageable pageable) {
        return (ArrayList<Contenido>) jdbcTemplate.query("select * from contenido", new ContenidoMapper());

    }

    @Override
    public Contenido buscarId(int id) {
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from contenido where id_contenido=?", params, new ContenidoMapper());
    }

}
