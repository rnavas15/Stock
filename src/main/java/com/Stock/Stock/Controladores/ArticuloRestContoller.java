/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import Enum.Categoria;
import Enum.UnidadesDeMedida;
import com.Stock.Stock.Servicios.IngredienteServicio;
import com.Stock.Stock.Servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rnavas
 */
  @RestController
@RequestMapping("/restArticulo")
public class ArticuloRestContoller {
  


    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    IngredienteServicio ingredienteServicio;

    @RequestMapping(value = "/eliminar/{id}", method =RequestMethod.POST)
    public String eliminar(ModelMap modelo,@PathVariable Integer id) {
        productoServicio.eliminarArticulo(id);
        modelo.put("categorias", Categoria.values());
        modelo.put("articulos", productoServicio.buscarProductosCompuestos());
        modelo.put("unidades", UnidadesDeMedida.values());
        modelo.put("productos", productoServicio.buscarArticulos());
        modelo.put("error", "Mensaje de error");
        return "redirect:/Articulo";
    }
}
