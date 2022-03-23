/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Respositorios.ProductoRepositorio;
import com.Stock.Stock.Servicios.GastoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rnavas
 */

@RestController
@RequestMapping("/Gasto")
public class GastoRestControlador {
    @Autowired
    GastoServicio gastoServicio;
     @RequestMapping(value = "/llenardata/", method = RequestMethod.GET)
     public List<Producto> llenardatos(ModelMap modelo) {
         return gastoServicio.buscarProductos();
     }
     
    
}
