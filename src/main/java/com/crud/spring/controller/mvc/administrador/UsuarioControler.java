/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.mvc.administrador;

import com.crud.spring.modelo.Usuario;
import com.crud.spring.service.GrupoService;
import com.crud.spring.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@RequestMapping("/admin/usuario")
public class UsuarioControler {

    @Autowired
    private GrupoService GrupoService;

    @Autowired
    private UsuarioService UsuarioService;

    @GetMapping()
    public ModelAndView getUsuarios(Pageable pageable) {
        ModelAndView mav = new ModelAndView("administrador/usuario");
        mav.addObject("usuario", new Usuario());
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaGrupos", GrupoService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getInfoUsuario(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/usuario");
        Usuario Usuario = UsuarioService.buscarId(id);
        mav.addObject("usuario", Usuario);
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaGrupos", GrupoService.listar(pageable));
        mav.addObject("msg", "update");
        return mav;
    }

    @PostMapping
    public String NewAndUptateUsuario(@ModelAttribute Usuario Usuario, Model model, Pageable pageable) {
        try {
            if (Usuario.getId_usuario()> 0) {
                UsuarioService.actualizar(Usuario);
            } else {
                UsuarioService.guardar(Usuario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("listaUsuarios", UsuarioService.listar(pageable));
        model.addAttribute("listaGrupos", GrupoService.listar(pageable));
        model.addAttribute("msg", "listar");
        return "administrador/usuario";
    }

    @GetMapping("/{id}")
    public ModelAndView eliminarUsuario(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/usuario");
        UsuarioService.eliminarId(id);
        mav.addObject("usuario", new Usuario());
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaGrupos", GrupoService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

}
