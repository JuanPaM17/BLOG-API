/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.Permiso;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IPermisoService {

    public boolean guardar(Permiso Permiso);

    public boolean actualizar(Permiso Permiso);

    public ArrayList<Permiso> listar(Pageable pageable);

    public Permiso buscarId(int id);
    
    public boolean eliminarId(int id);
    
    public Permiso buscarNombre(String nombre_permiso);

}
