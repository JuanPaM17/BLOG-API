/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.Contenido;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IContenidoService {

    public boolean guardar(Contenido contenido);

    public boolean actualizar(Contenido contenido);

    public ArrayList<Contenido> listar(Pageable pageable);

    public Contenido buscarId(int id);

}
