/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rnavas
 */

@RestController
@RequestMapping("/Proveedor1")
public class ProveedorRestController {
    
    @Autowired
    ProveedorServicio proveedorServicio;
     @PostMapping(value = "/baja")
  @ResponseStatus(HttpStatus.CREATED)
  public String bajaProveedor(ModelMap modelo, @RequestParam String id) throws Exception{
         System.out.println("ID "+id);
     proveedorServicio.altaBajaProveedor(id);
     
      
      return "Modificado";
      
  }
    
    
}
