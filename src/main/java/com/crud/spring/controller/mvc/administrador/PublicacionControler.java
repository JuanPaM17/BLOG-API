/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.mvc.administrador;

import com.crud.spring.modelo.Post;
import com.crud.spring.service.CategoriaService;
import com.crud.spring.service.PostService;
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
@RequestMapping("/admin/publicacion")
public class PublicacionControler {

    @Autowired
    private PostService postService;

    @Autowired
    private UsuarioService UsuarioService;

    @Autowired
    private CategoriaService CategoriaService;

    @GetMapping()
    public ModelAndView getpublicaciones(Pageable pageable) {
        ModelAndView mav = new ModelAndView("administrador/publicacion");
        mav.addObject("post", new Post());
        mav.addObject("listaPublicaciones", postService.listar(pageable));
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaCategorias", CategoriaService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getInfoPublicacion(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/publicacion");
        Post Post = postService.buscarId(id);
        mav.addObject("post", Post);
        mav.addObject("listaPublicaciones", postService.listar(pageable));
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaCategorias", CategoriaService.listar(pageable));
        mav.addObject("msg", "update");
        return mav;
    }

    @PostMapping
    public String NewAndUptatePublicacion(@ModelAttribute Post Post, Model model, Pageable pageable) {
        Log log = LogFactory.getLog(getClass());
        try {
            if (Post.getId_post() > 0) {
                postService.actualizar(Post);
            } else {
                postService.guardar(Post);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        model.addAttribute("post", new Post());
        model.addAttribute("listaPublicaciones", postService.listar(pageable));
        model.addAttribute("listaUsuarios", UsuarioService.listar(pageable));
        model.addAttribute("listaCategorias", CategoriaService.listar(pageable));
        model.addAttribute("msg", "listar");
        return "administrador/publicacion";
    }

    @GetMapping("/{id}")
    public ModelAndView eliminarPublicacion(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/publicacion");
        postService.eliminarId(id);
        mav.addObject("post", new Post());
        mav.addObject("listaPublicaciones", postService.listar(pageable));
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaCategorias", CategoriaService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

}
