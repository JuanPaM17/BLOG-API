/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.Categoria;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface ICategoriaService<T> {
    
    public boolean guardar(Categoria categoria);
    
    public boolean actualizar(Categoria categoria);
    
    public ArrayList<Categoria> listar(Pageable pageable);
    
    public Categoria buscarId(int id);
    
    public boolean eliminarId(int id);
    
}
