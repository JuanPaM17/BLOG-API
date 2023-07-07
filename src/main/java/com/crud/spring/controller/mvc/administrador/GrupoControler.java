/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.mvc.administrador;

import com.crud.spring.modelo.Grupo;
import com.crud.spring.modelo.GrupoPermiso;
import com.crud.spring.modelo.Permiso;
import com.crud.spring.service.GrupoPermisoService;
import com.crud.spring.service.GrupoService;
import com.crud.spring.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sarit
 */
@Controller
@RequestMapping("/admin/grupo")
public class GrupoControler {

    private int id_grupo;

    @Autowired
    private PermisoService permisoService;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private GrupoPermisoService GrupoPermisoService;

    @GetMapping()
    public ModelAndView getGrupos(Pageable pageable) {
        ModelAndView mav = new ModelAndView("administrador/grupo");
        mav.addObject("grupo", new Grupo());
        mav.addObject("listaGrupos", grupoService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getInfoGrupo(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/grupo");
        Grupo Grupo = grupoService.buscarId(id);
        id_grupo = Grupo.getId_grupo();
        mav.addObject("grupo", Grupo);
        mav.addObject("listaGrupos", grupoService.listar(pageable));
        mav.addObject("listaPermisoGrupoIdNoTiene", GrupoPermisoService.combinar(pageable, id));
        mav.addObject("listaPermisoGrupo", GrupoPermisoService.listarIdGrupo(pageable, id));
        mav.addObject("msg", "update");
        return mav;
    }

    @PostMapping
    public String NewAndUptateGrupo(@ModelAttribute Grupo Grupo, Model model, Pageable pageable) {
        if (Grupo.getId_grupo() > 0) {
            grupoService.actualizar(Grupo);
        } else {
            grupoService.guardar(Grupo);
        }
        model.addAttribute("grupo", new Grupo());
        model.addAttribute("listaGrupos", grupoService.listar(pageable));
        model.addAttribute("msg", "listar");
        return "administrador/grupo";
    }

    @GetMapping("/{id}")
    public ModelAndView eliminarGrupo(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/grupo");
        grupoService.eliminarId(id);
        mav.addObject("grupo", new Grupo());
        mav.addObject("listaGrupos", grupoService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

    @GetMapping("/delete/permiso/{id_grupo_permiso}")
    public ModelAndView eliminarPermisoGru(Pageable pageable, @PathVariable int id_grupo_permiso) {
        GrupoPermisoService.eliminarId(id_grupo_permiso);
        ModelAndView mav = new ModelAndView("administrador/grupo");
        Grupo Grupo = grupoService.buscarId(id_grupo);
        mav.addObject("grupo", Grupo);
        mav.addObject("listaGrupos", grupoService.listar(pageable));
        mav.addObject("listaPermisoGrupoIdNoTiene", GrupoPermisoService.combinar(pageable, id_grupo));
        mav.addObject("listaPermisoGrupo", GrupoPermisoService.listarIdGrupo(pageable, id_grupo));
        mav.addObject("msg", "update");
        return mav;
    }

    @GetMapping("/add/permiso/{id_grupo_permiso}/{nombre_permiso}")
    public ModelAndView añadirPermisoGru(Pageable pageable, @PathVariable int id_grupo_permiso, @PathVariable String nombre_permiso) {
        Permiso permiso = permisoService.buscarNombre(nombre_permiso);
        GrupoPermisoService.guardar(new GrupoPermiso(0, permiso.getId_permiso(), id_grupo));
        ModelAndView mav = new ModelAndView("administrador/grupo");
        Grupo Grupo = grupoService.buscarId(id_grupo);
        mav.addObject("grupo", Grupo);
        mav.addObject("listaGrupos", grupoService.listar(pageable));
        mav.addObject("listaPermisoGrupoIdNoTiene", GrupoPermisoService.combinar(pageable, id_grupo));
        mav.addObject("listaPermisoGrupo", GrupoPermisoService.listarIdGrupo(pageable, id_grupo));
        mav.addObject("msg", "update");
        return mav;
    }

}
