/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.Usuario;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IUsuarioService {

    public boolean guardar(Usuario Usuario);

    public boolean actualizar(Usuario Usuario);

    public ArrayList<Usuario> listar(Pageable pageable);

    public Usuario buscarId(int id);

    public boolean eliminarId(int id);
    
    public Usuario inicioSesion(String correo);
    
}
