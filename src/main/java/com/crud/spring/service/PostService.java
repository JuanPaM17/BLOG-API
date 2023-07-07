/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.PostMapper;
import com.crud.spring.modelo.Post;
import com.crud.spring.serviceInterfaz.IPostService;
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
public class PostService implements IPostService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean guardar(Post Post) {
        try {

            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);
            try {
                String sql = String.format("INSERT INTO post (titulo,url_img,extracto,id_usuario,id_categoria,img_destacada,tipo) VALUES ('%s','%s','%s','%d','%d','%s','%s')", Post.getTitulo(), Post.getUrlImg(), Post.getExtracto(), Post.getId_usuario(), Post.getId_categoria(), Post.getImgDestacada(), Post.getTipo());
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
    public boolean actualizar(Post Post) {
        try {
            String sql = String.format("UPDATE post set titulo='%s',url_img='%s',extracto='%s',id_usuario='%d',id_categoria='%d',img_destacada='%s',tipo='%s' where id_post='%d'", Post.getTitulo(), Post.getUrlImg(), Post.getExtracto(), Post.getId_usuario(), Post.getId_categoria(), Post.getImgDestacada(), Post.getTipo(), Post.getId_post());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<Post> listar(Pageable pageable) {
        return (ArrayList<Post>) jdbcTemplate.query("select * from post", new PostMapper());
    }

    @Override
    public Post buscarId(int id) {
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from post where id_post=?", params, new PostMapper());
    }

    @Override
    public boolean eliminarId(int id) {
        try {
            String sql = String.format("DELETE FROM post where id_post='%d'", id);
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al eliminar");
        }
    }

}
