/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.PostMetadata;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IPostMetadataService {

    public boolean guardar(PostMetadata PostMetadata);

    public boolean actualizar(PostMetadata PostMetadata);

    public ArrayList<PostMetadata> listar(Pageable pageable);

    public PostMetadata buscarId(int id);
}
