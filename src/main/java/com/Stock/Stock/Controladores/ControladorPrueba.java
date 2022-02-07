/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import Enum.Categoria;
import Enum.UnidadesDeMedida;
import com.Stock.Stock.Servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rnavas
 */
@Controller
@RequestMapping("/Prueba")
public class ControladorPrueba {
    
    @Autowired
    ProductoServicio productoServicio;
    
    
    @GetMapping("")
    public String articulos(ModelMap modelo){
                 
        modelo.put("categorias", Categoria.values());
        modelo.put("unidades", UnidadesDeMedida.values());
        modelo.put("productos",productoServicio.buscarArticulos());
        return "/Starter";
    }
    
    @PostMapping("/crear-articulo")
    public String crearArticulo(ModelMap modelo,@RequestParam String fabricante, @RequestParam String nombre,@RequestParam Double costo, @RequestParam Double precio,@RequestParam MultipartFile foto, @RequestParam String categoria,@RequestParam String unidad) throws Exception{
        
        productoServicio.crearArticulo(fabricante,0 , nombre, costo, precio,foto,categoria,unidad);
        modelo.put("articulos",productoServicio.buscarArticulos());
        return "redirect:";
    }
    
    
    
}


