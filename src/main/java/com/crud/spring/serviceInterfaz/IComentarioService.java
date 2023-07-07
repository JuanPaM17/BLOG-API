/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.Comentario;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IComentarioService {

    public boolean guardar(Comentario comentario);

    public boolean actualizar(Comentario comentario);

    public ArrayList<Comentario> listar(Pageable pageable);

    public Comentario buscarId(int id);

    public boolean eliminarId(int id);
}
