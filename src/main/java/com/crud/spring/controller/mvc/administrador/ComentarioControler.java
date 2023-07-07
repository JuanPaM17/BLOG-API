/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.mvc.administrador;

import com.crud.spring.modelo.Comentario;
import com.crud.spring.service.ComentarioService;
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
@RequestMapping("/admin/comentario")
public class ComentarioControler {

    @Autowired
    private PostService postService;

    @Autowired
    private UsuarioService UsuarioService;

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping()
    public ModelAndView getComentarios(Pageable pageable) {
        ModelAndView mav = new ModelAndView("administrador/comentario");
        mav.addObject("comentario", new Comentario());
        mav.addObject("listaPublicaciones", postService.listar(pageable));
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaComentarios", comentarioService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getInfoComentario(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/comentario");
        Comentario Comentario = comentarioService.buscarId(id);
        mav.addObject("comentario", Comentario);
        mav.addObject("listaPublicaciones", postService.listar(pageable));
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaComentarios", comentarioService.listar(pageable));
        mav.addObject("msg", "update");
        return mav;
    }

    @PostMapping
    public String NewAndUptateComentario(@ModelAttribute Comentario Comentario, Model model, Pageable pageable) {
        Log log = LogFactory.getLog(getClass());
        log.info(Comentario.toString());
        try {
            if (Comentario.getId_comentario() > 0) {
                comentarioService.actualizar(Comentario);
            } else {
                comentarioService.guardar(Comentario);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        model.addAttribute("comentario", new Comentario());
        model.addAttribute("listaPublicaciones", postService.listar(pageable));
        model.addAttribute("listaUsuarios", UsuarioService.listar(pageable));
        model.addAttribute("listaComentarios", comentarioService.listar(pageable));
        model.addAttribute("msg", "listar");
        return "administrador/comentario";
    }

    @GetMapping("/{id}")
    public ModelAndView eliminarComentario(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/comentario");
        comentarioService.eliminarId(id);
        mav.addObject("comentario", new Comentario());
        mav.addObject("listaPublicaciones", postService.listar(pageable));
        mav.addObject("listaUsuarios", UsuarioService.listar(pageable));
        mav.addObject("listaComentarios", comentarioService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

}
