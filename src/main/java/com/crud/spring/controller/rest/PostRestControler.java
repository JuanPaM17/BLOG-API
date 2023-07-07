package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Post;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.PostService;
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
@RequestMapping("/api/v1/post")
public class PostRestControler {

    @Autowired
    private PostService PostService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody Post Post) {
        return ResponseEntity.ok(new RestBase(PostService.guardar(Post)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody Post Post) {
        return ResponseEntity.ok(new RestBase(PostService.actualizar(Post)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<Post>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(PostService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<Post> buscarId(@PathVariable int id) {
        return ResponseEntity.ok(PostService.buscarId(id));
    }

}
