/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.Post;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IPostService {

    public boolean guardar(Post Post);

    public boolean actualizar(Post Post);

    public ArrayList<Post> listar(Pageable pageable);

    public Post buscarId(int id);
    
    public boolean eliminarId(int id);
}
