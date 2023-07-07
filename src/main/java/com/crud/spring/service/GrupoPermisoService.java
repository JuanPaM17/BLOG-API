/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.service;

import com.crud.spring.mapper.GrupoPermisoMapper;
import com.crud.spring.mapper.GrupoPermisoMapper2;
import com.crud.spring.modelo.GrupoPermiso;
import com.crud.spring.modelo.Permiso;
import com.crud.spring.serviceInterfaz.IGrupoPermisoService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class GrupoPermisoService implements IGrupoPermisoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private PermisoService PermisoService;

    @Override
    public boolean guardar(GrupoPermiso GrupoPermiso) {
        try {
            TransactionDefinition def = new DefaultTransactionDefinition();
            TransactionStatus status = transactionManager.getTransaction(def);

            try {
                String sql = String.format("INSERT INTO grupo_permiso (id_permiso, id_grupo) VALUES ('%d', '%d')", GrupoPermiso.getId_permiso(), GrupoPermiso.getId_grupo());
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
    public boolean actualizar(GrupoPermiso GrupoPermiso) {
        try {
            String sql = String.format("UPDATE grupo_permiso set id_permiso='%d',id_grupo='%d' where id_grupo_permiso='%d'", GrupoPermiso.getId_permiso(), GrupoPermiso.getId_grupo(), GrupoPermiso.getId_grupo_permiso());
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al actualizar");
        }
    }

    @Override
    public ArrayList<GrupoPermiso> listar(Pageable pageable) {
        return (ArrayList<GrupoPermiso>) jdbcTemplate.query("select * from grupo_permiso", new GrupoPermisoMapper());
    }

    @Override
    public GrupoPermiso buscarId(int id) {
        Object[] params = new Object[]{id};
        return jdbcTemplate.queryForObject("select * from grupo_permiso where id_grupo_permiso=?", params, new GrupoPermisoMapper());
    }

    @Override
    public ArrayList<GrupoPermiso> listarIdGrupo(Pageable pageable, int id) {
        Object[] params = new Object[]{id};
        return (ArrayList<GrupoPermiso>) jdbcTemplate.query("SELECT gp.id_grupo_permiso,p.nombre from grupo_permiso gp INNER JOIN permiso p ON p.id_permiso=gp.id_permiso WHERE gp.id_grupo=?", params, new GrupoPermisoMapper2());
    }

    @Override
    public ArrayList<GrupoPermiso> listarIdGrupoNo(Pageable pageable, int id) {
        Object[] params = new Object[]{id};
        return (ArrayList<GrupoPermiso>) jdbcTemplate.query("SELECT gp.id_grupo_permiso,p.nombre from grupo_permiso gp INNER JOIN permiso p ON p.id_permiso=gp.id_permiso WHERE gp.id_grupo!=?", params, new GrupoPermisoMapper2());
    }

    public ArrayList<GrupoPermiso> combinar(Pageable pageable, int id) {
        ArrayList<GrupoPermiso> grupoPermisos = this.listarIdGrupo(pageable, id);
        ArrayList<GrupoPermiso> grupoPermisosNO = this.listarIdGrupoNo(pageable, id);
        ArrayList<GrupoPermiso> grupoPermisosNoTiene = new ArrayList<>();
        Set<String> nombresPermiso = new HashSet<>();

        for (GrupoPermiso grupoPermiso : grupoPermisos) {
            nombresPermiso.add(grupoPermiso.getNombre_permiso());
        }

        for (GrupoPermiso grupoPermisoNO : grupoPermisosNO) {
            String nombrePermisoNO = grupoPermisoNO.getNombre_permiso();
            if (!nombresPermiso.contains(nombrePermisoNO)) {
                grupoPermisosNoTiene.add(grupoPermisoNO);
            }
        }
        return grupoPermisosNoTiene;
    }

    @Override
    public boolean eliminarId(int id) {
        try {
            String sql = String.format("DELETE FROM grupo_permiso where id_grupo_permiso='%d'", id);
            int rowsAffected = jdbcTemplate.update(sql);
            return rowsAffected > 0;
        } catch (DataAccessException | TransactionException e) {
            throw new NullPointerException("Error al eliminar");
        }
    }

}
