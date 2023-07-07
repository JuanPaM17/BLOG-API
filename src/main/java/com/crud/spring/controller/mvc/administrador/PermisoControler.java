/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.mvc.administrador;

import com.crud.spring.modelo.Permiso;
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


@Controller
@RequestMapping("/admin/permiso")
public class PermisoControler {

    @Autowired
    private PermisoService permisoService;

    @GetMapping()
    public ModelAndView getPermisos(Pageable pageable) {
        ModelAndView mav = new ModelAndView("administrador/permiso");
        mav.addObject("permiso", new Permiso());
        mav.addObject("listaPermisos", permisoService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getInfoPermiso(Pageable pageable, @PathVariable int id) {

        ModelAndView mav = new ModelAndView("administrador/permiso");
        Permiso Permiso = permisoService.buscarId(id);
        mav.addObject("permiso", Permiso);
        mav.addObject("listaPermisos", permisoService.listar(pageable));
        mav.addObject("msg", "update");
        return mav;
    }

    @PostMapping
    public String NewAndUptatePermiso(@ModelAttribute Permiso Permiso, Model model, Pageable pageable) {
        if (Permiso.getId_permiso()> 0) {
            permisoService.actualizar(Permiso);
        } else {
            permisoService.guardar(Permiso);
        }
        model.addAttribute("permiso", new Permiso());
        model.addAttribute("listaPermisos", permisoService.listar(pageable));
        model.addAttribute("msg", "listar");
        return "administrador/permiso";
    }

    @GetMapping("/{id}")
    public ModelAndView eliminarPermiso(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/permiso");
        permisoService.eliminarId(id);
        mav.addObject("permiso", new Permiso());
        mav.addObject("listaPermisos", permisoService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

}
