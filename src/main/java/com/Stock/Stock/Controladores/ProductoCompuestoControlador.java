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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rnavas
 */
@Controller
@RequestMapping("/ProductoCompuesto")
public class ProductoCompuestoControlador {
    
    @Autowired
    ProductoServicio productoServicio;
    
    
    @GetMapping("")
    public String ProductoCompuesto(ModelMap modelo){
                 
        modelo.put("categorias", Categoria.values());
        modelo.put("articulos",productoServicio.buscarArticulos());
        modelo.put("unidades", UnidadesDeMedida.values());
        modelo.put("productos",productoServicio.buscarProductosCompuestos());
        return "/Producto/productoCompuesto";
    }
    
    @PostMapping("/crear-productoCompuesto")
    public String crearProductoCompuesto(ModelMap modelo,@RequestParam String nombre,@RequestParam(defaultValue = "0" ) Double costo, @RequestParam Double precio,@RequestParam MultipartFile foto, @RequestParam String categoria) throws Exception{
        
        productoServicio.crearProductoCompuesto(nombre, costo, precio,foto,categoria);
        modelo.put("articulos",productoServicio.buscarArticulos());
        modelo.put("productos",productoServicio.buscarProductosCompuestos());
        return "redirect:";
    }
    
    @PostMapping("/modificar-productoCompuesto")
    public String modificarProductoCompuesto(ModelMap modelo,@RequestParam Integer prodId, @RequestParam String nombre,@RequestParam(defaultValue = "0" ) Double costo, @RequestParam Double precio,@RequestParam MultipartFile foto, @RequestParam String categoria) throws Exception{
        
        productoServicio.modificarProductoCompuesto(prodId,nombre, costo, precio,foto,categoria);
        
        modelo.put("articulos",productoServicio.buscarArticulos());
        modelo.put("productos",productoServicio.buscarProductosCompuestos());
        return "redirect:";
    }

    @RequestMapping("/Refrescar")
    public String recargar(ModelMap modelo){
                 
        modelo.put("productosA",productoServicio.buscarProductosCompuestos());
       return  "/Producto/Refrescar";
    }
}


