/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.rest;

import com.crud.spring.modelo.GrupoPermiso;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.GrupoPermisoService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author sarit
 */
@RestController
@RequestMapping("/api/v1/grupo/permiso")
public class GrupoPermisoRestControler {

    @Autowired
    private GrupoPermisoService grupoPermisoService;

    // Insertar
    @PutMapping
    public ResponseEntity guardar(@RequestBody GrupoPermiso GrupoPermiso) {
        return ResponseEntity.ok(new RestBase(grupoPermisoService.guardar(GrupoPermiso)));
    }

    // Actualizar
    @PostMapping
    public ResponseEntity actualizar(@RequestBody GrupoPermiso GrupoPermiso) {
        return ResponseEntity.ok(new RestBase(grupoPermisoService.actualizar(GrupoPermiso)));
    }

    // BuscarDatos
    @GetMapping
    public ResponseEntity<ArrayList<GrupoPermiso>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(grupoPermisoService.listar(pageable));
    }

    // BuscarDatosGrupo
    @GetMapping("/grupo/{id}")
    public ResponseEntity<ArrayList<GrupoPermiso>> listarIdGrupo(SpringDataWebProperties.Pageable pageable, @PathVariable int id) {
        return ResponseEntity.ok(grupoPermisoService.listarIdGrupo(pageable, id));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<GrupoPermiso> listar(@PathVariable int id) {
        return ResponseEntity.ok(grupoPermisoService.buscarId(id));
    }

    @GetMapping("/grupo/no/{id}")
    public ResponseEntity<ArrayList<GrupoPermiso>> listarIdGrupoNo(Pageable pageable, @PathVariable int id) {
        return ResponseEntity.ok(grupoPermisoService.combinar(pageable, id));
    }

}
