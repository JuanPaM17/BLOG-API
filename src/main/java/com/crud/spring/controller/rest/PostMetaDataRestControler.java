package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Grupo;
import com.crud.spring.modelo.PostMetadata;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.GrupoService;
import com.crud.spring.service.PostMetadataService;
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
@RequestMapping("/api/v1/post/metadata")
public class PostMetaDataRestControler {

    @Autowired
    private PostMetadataService PostMetadataService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody PostMetadata PostMetadata) {
        return ResponseEntity.ok(new RestBase(PostMetadataService.guardar(PostMetadata)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody PostMetadata PostMetadata) {
        return ResponseEntity.ok(new RestBase(PostMetadataService.actualizar(PostMetadata)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<PostMetadata>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(PostMetadataService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<PostMetadata> listar(@PathVariable int id) {
        return ResponseEntity.ok(PostMetadataService.buscarId(id));
    }

}
