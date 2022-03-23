/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Servicios.ProductoServicio;
import com.Stock.Stock.Servicios.StockServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rnavas
 */
@RestController
@RequestMapping("/Stock1")
public class StockRestController {
    
     @Autowired
    ProductoServicio productoServicio;
     @Autowired
     StockServicio stockServicio;
    

    @RequestMapping(value = "/productos", method = RequestMethod.GET)
    public Integer cantarticulos() {
        return productoServicio.buscarProductosStandar().size();
        
    }
     @RequestMapping(value = "/articulos", method = RequestMethod.GET)
    public Integer cantproductos() {
        return productoServicio.buscarArticulos().size();
        
    }
    
  @PostMapping(value = "/modificarStock")
  @ResponseStatus(HttpStatus.CREATED)
  public String modificarStock(ModelMap modelo, @RequestParam String id,@RequestParam String stock) throws Exception{
     stockServicio.registrarMovimiento(id, stock);
     
      
      return "Modificado";
      
  }
  
   
}
