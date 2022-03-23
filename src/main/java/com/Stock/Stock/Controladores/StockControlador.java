/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.MovimientoStock;
import com.Stock.Stock.Servicios.ProductoServicio;
import com.Stock.Stock.Servicios.StockServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rnavas
 */
@Controller
@RequestMapping("/Stock")
public class StockControlador {

    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    StockServicio stockServicio;

    @GetMapping("")
    public String pedidos(ModelMap modelo) {

        modelo.put("cantprod", productoServicio.buscarArticulos().size());
        modelo.put("cantart", productoServicio.buscarArticulos().size());

        return "/Producto/Stock";
    }
    
   @RequestMapping("/Movimientos/{id}")
    public String pedidos(ModelMap modelo,@PathVariable Integer id) {
        System.out.println("ID " +id);
       List<MovimientoStock> mov=stockServicio.buscarMovimientos(id);
       if(mov.isEmpty()){
           modelo.put("error","El producto no tiene movimientos de Stock");
       }
        
        
        
       modelo.put("movimientos",mov);

        return  "/Producto/Refrescar";
    }
    

}
