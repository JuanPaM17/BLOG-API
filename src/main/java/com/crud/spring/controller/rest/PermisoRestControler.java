/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Permiso;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.PermisoService;
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

@RestController
@RequestMapping("/api/v1/permiso")
public class PermisoRestControler {

    @Autowired
    private PermisoService permisoService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody Permiso permiso) {
        return ResponseEntity.ok(new RestBase(permisoService.guardar(permiso)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody Permiso permiso) {
        return ResponseEntity.ok(new RestBase(permisoService.actualizar(permiso)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<Permiso>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(permisoService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<Permiso> buscarId(@PathVariable int id) {
        return ResponseEntity.ok(permisoService.buscarId(id));
    }

    // Buscar Nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Permiso> buscarNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(permisoService.buscarNombre(nombre));
    }
}
