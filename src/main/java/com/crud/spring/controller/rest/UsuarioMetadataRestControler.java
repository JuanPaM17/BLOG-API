package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Usuario;
import com.crud.spring.modelo.UsuarioMetadata;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.UsuarioMetadataService;
import com.crud.spring.service.UsuarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sarit
 */
@RestController
@RequestMapping("/api/v1/usuario/metadata")
public class UsuarioMetadataRestControler {

    @Autowired
    private UsuarioMetadataService usuarioMetadataService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody UsuarioMetadata UsuarioMetadata) {
        return ResponseEntity.ok(new RestBase(usuarioMetadataService.guardar(UsuarioMetadata)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody UsuarioMetadata UsuarioMetadata) {
        return ResponseEntity.ok(new RestBase(usuarioMetadataService.actualizar(UsuarioMetadata)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<UsuarioMetadata>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(usuarioMetadataService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioMetadata> listar(@PathVariable int id) {
        return ResponseEntity.ok(usuarioMetadataService.buscarId(id));
    }

}
