package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Comentario;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.ComentarioService;
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
@RequestMapping("/api/v1/comentario")
public class ComentarioRestControler {

    @Autowired
    private ComentarioService ComentarioService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody Comentario Comentario) {
        return ResponseEntity.ok(new RestBase(ComentarioService.guardar(Comentario)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody Comentario Comentario) {
        return ResponseEntity.ok(new RestBase(ComentarioService.actualizar(Comentario)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<Comentario>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(ComentarioService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> listar(@PathVariable int id) {
        return ResponseEntity.ok(ComentarioService.buscarId(id));
    }

}
