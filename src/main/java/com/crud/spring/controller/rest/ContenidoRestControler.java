package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Contenido;
import com.crud.spring.modelo.Grupo;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.ContenidoService;
import com.crud.spring.service.GrupoService;
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
@RequestMapping("/api/v1/contenido")
public class ContenidoRestControler {

    @Autowired
    private ContenidoService ContenidoService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody Contenido Contenido) {
        return ResponseEntity.ok(new RestBase(ContenidoService.guardar(Contenido)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody Contenido Contenido) {
        return ResponseEntity.ok(new RestBase(ContenidoService.actualizar(Contenido)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<Contenido>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(ContenidoService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<Contenido> listar(@PathVariable int id) {
        return ResponseEntity.ok(ContenidoService.buscarId(id));
    }

}
