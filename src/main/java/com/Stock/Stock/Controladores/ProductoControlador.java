/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.Categoria;
import com.Stock.Stock.Entidades.Lote;
import com.Stock.Stock.Servicios.LoteServicio;
import com.Stock.Stock.Servicios.ProductoServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@RequestMapping("/Producto")
public class ProductoControlador {
    
    @Autowired
    ProductoServicio productoServicio;
    
    
    @GetMapping("")
    public String productos(ModelMap modelo){
                 
        modelo.put("categorias", Categoria.values());
        modelo.put("productos",productoServicio.buscarProductos());
        return "/Producto/producto";
    }
    
    @PostMapping("/crear-producto")
    public String crearProducto(ModelMap modelo,@RequestParam String fabricante, @RequestParam String nombre,@RequestParam Double costo, @RequestParam Double precio,@RequestParam MultipartFile foto, @RequestParam String categoria) throws Exception{
        
        productoServicio.crearProdEstandar(fabricante,0 , nombre, costo, precio,foto);
        modelo.put("productos",productoServicio.buscarProductos());
        return"/Producto/producto";
    }
    
    
    
}


