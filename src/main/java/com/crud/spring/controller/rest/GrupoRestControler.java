package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Grupo;
import com.crud.spring.modelo.common.RestBase;
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
@RequestMapping("/api/v1/grupo")
public class GrupoRestControler {

    @Autowired
    private GrupoService grupoService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody Grupo grupo) {
        return ResponseEntity.ok(new RestBase(grupoService.guardar(grupo)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody Grupo grupo) {
        return ResponseEntity.ok(new RestBase(grupoService.actualizar(grupo)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<Grupo>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(grupoService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<Grupo> listar(@PathVariable int id) {
        return ResponseEntity.ok(grupoService.buscarId(id));
    }

}
