/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.GrupoPermiso;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IGrupoPermisoService {

    public boolean guardar(GrupoPermiso GrupoPermiso);

    public boolean actualizar(GrupoPermiso GrupoPermiso);

    public ArrayList<GrupoPermiso> listar(Pageable pageable);

    public GrupoPermiso buscarId(int id);

    public ArrayList<GrupoPermiso> listarIdGrupo(Pageable pageable, int id);

    public boolean eliminarId(int id);

    public ArrayList<GrupoPermiso> listarIdGrupoNo(Pageable pageable, int id);

}
