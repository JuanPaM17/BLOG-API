/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.Grupo;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IGrupoService {

    public boolean guardar(Grupo Grupo);

    public boolean actualizar(Grupo Grupo);

    public ArrayList<Grupo> listar(Pageable pageable);

    public Grupo buscarId(int id);
    
    public boolean eliminarId(int id);

}
