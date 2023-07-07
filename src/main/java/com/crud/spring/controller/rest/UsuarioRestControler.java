package com.crud.spring.controller.rest;

import com.crud.spring.modelo.Usuario;
import com.crud.spring.modelo.common.RestBase;
import com.crud.spring.service.UsuarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@RequestMapping("/api/v1/usuario")
public class UsuarioRestControler {

    @Autowired
    private UsuarioService usuarioService;

    // Insertar
    @PutMapping
    @CacheEvict(value = "usuarios", allEntries = true)
    public ResponseEntity guardar(@RequestBody Usuario Usuario) {
        return ResponseEntity.ok(new RestBase(usuarioService.guardar(Usuario)));
    }

    // Actualizar
    @PostMapping
    @CacheEvict(value = "usuarios", allEntries = true)
    public ResponseEntity actualizar(@RequestBody Usuario Usuario) {
        return ResponseEntity.ok(new RestBase(usuarioService.actualizar(Usuario)));
    }

    // BuscarDatos
    @GetMapping
    @Cacheable(value = "usuarios")
    public ResponseEntity<ArrayList<Usuario>> listar(SpringDataWebProperties.Pageable pageable) {
        return ResponseEntity.ok(usuarioService.listar(pageable));
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarId(@PathVariable int id) {
        return ResponseEntity.ok(usuarioService.buscarId(id));
    }

    // IniciarSesion
    @GetMapping("/login/{correo}")
    public ResponseEntity<Usuario> IniciarSesion(@PathVariable String correo) {
        return ResponseEntity.ok(usuarioService.inicioSesion(correo));
    }

}
