/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import Enum.UnidadesDeMedida;
import Enum.Categoria;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rnavas
 */
@Controller
@RequestMapping("/Articulo")
public class ArticuloControlador {
    
    @Autowired
    ProductoServicio productoServicio;
    
    
    @GetMapping("")
    public String articulos(ModelMap modelo){
                 
        modelo.put("categorias", Categoria.values());
        modelo.put("unidades", UnidadesDeMedida.values());
        modelo.put("productos",productoServicio.buscarArticulos());
        return "/Producto/articulo";
    }
    
    @PostMapping("/crear-articulo")
    public String crearArticulo(ModelMap modelo,@RequestParam String fabricante, @RequestParam String nombre,@RequestParam (defaultValue = "0")Double costo, @RequestParam (defaultValue = "0") Double precio,@RequestParam MultipartFile foto, @RequestParam String categoria,@RequestParam String unidad) throws Exception{
        
        productoServicio.crearArticulo(fabricante,0 , nombre, costo, precio,foto,categoria,unidad);
        modelo.put("articulos",productoServicio.buscarArticulos());
        return "redirect:/Articulo";
    }
    
    @PostMapping("/modificar-articulo")
    public String modificarArticulo(ModelMap modelo,@RequestParam  String id ,@RequestParam String fabricante, @RequestParam String nombre,@RequestParam Double costo, @RequestParam Double precio,@RequestParam MultipartFile foto, @RequestParam String categoria,@RequestParam String unidad) throws Exception{
  
        productoServicio.modificarArticulo(Integer.valueOf(id),fabricante,0 , nombre, costo, precio,foto,categoria,unidad);
        modelo.put("articulos",productoServicio.buscarArticulos());
        return "redirect:";
    }
    @RequestMapping("/Stock")
    public String recargar(ModelMap modelo){
                 
         modelo.put("categorias", Categoria.values());
        modelo.put("unidades", UnidadesDeMedida.values());
        modelo.put("productos",productoServicio.buscarArticulos());
       return  "/Producto/Refrescar";
    }
    
}


