/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.controller.mvc.administrador;

import com.crud.spring.modelo.Categoria;
import com.crud.spring.service.CategoriaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sarit
 */
@Controller
@RequestMapping("/admin/categoria")
public class CategoriaControler {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ModelAndView getCategorias(Pageable pageable) {
        ModelAndView mav = new ModelAndView("administrador/categoria");
        mav.addObject("categoria", new Categoria());
        mav.addObject("listaCategorias", categoriaService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getInfoCategoria(Pageable pageable, @PathVariable int id) {

        ModelAndView mav = new ModelAndView("administrador/categoria");
        Categoria cate = categoriaService.buscarId(id);
        mav.addObject("categoria", cate);
        mav.addObject("listaCategorias", categoriaService.listar(pageable));
        mav.addObject("msg", "update");
        return mav;
    }

    @PostMapping
    public String NewAndUptateCategoria(@ModelAttribute Categoria categoria, Model model, Pageable pageable) {
        if (categoria.getId_categoria() > 0) {
            categoriaService.actualizar(categoria);
        } else {
            categoriaService.guardar(categoria);
        }
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("listaCategorias", categoriaService.listar(pageable));
        model.addAttribute("msg", "listar");
        return "administrador/categoria";
    }

    @GetMapping("/{id}")
    public ModelAndView eliminarCategoria(Pageable pageable, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("administrador/categoria");
        categoriaService.eliminarId(id);
        mav.addObject("categoria", new Categoria());
        mav.addObject("listaCategorias", categoriaService.listar(pageable));
        mav.addObject("msg", "listar");
        return mav;
    }

}
