/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.spring.serviceInterfaz;

import com.crud.spring.modelo.UsuarioMetadata;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 *
 * @author sarit
 */
public interface IUsuarioMetadataService {

    public boolean guardar(UsuarioMetadata UsuarioMetadata);

    public boolean actualizar(UsuarioMetadata UsuarioMetadata);

    public ArrayList<UsuarioMetadata> listar(Pageable pageable);

    public UsuarioMetadata buscarId(int id);
}
