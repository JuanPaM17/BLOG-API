package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Categoria;
import com.crud.spring.modelo.Grupo;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.CategoriaService;
import com.crud.spring.service.GrupoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/v1/categoria")
public class CategoriaRestControler {

    @Autowired
    private CategoriaService categoriaService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody Categoria Categoria) {
        return ResponseEntity.ok(new RestBase(categoriaService.guardar(Categoria)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody Categoria Categoria) {
        return ResponseEntity.ok(new RestBase(categoriaService.actualizar(Categoria)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<Categoria>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(categoriaService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarId(@PathVariable int id) {
        return ResponseEntity.ok(categoriaService.buscarId(id));
    }

    // Eliminar ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarID(@PathVariable int id) {
        categoriaService.eliminarId(id);
        return ResponseEntity.ok("Recurso eliminado correctamente");
    }

}
