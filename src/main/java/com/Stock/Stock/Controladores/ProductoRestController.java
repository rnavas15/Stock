/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Servicios.ProductoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rnavas
 */

@RestController

   

@RequestMapping("/productos2")

public class ProductoRestController {
    
    @Autowired
    ProductoServicio productoServicio;
    

    @GetMapping(path="/test")
    public ResponseEntity<List<Producto>> ListaDeProductos(){
        System.out.println("LLAMO AL CONTROLADOR");
        List<Producto> productos=productoServicio.buscarProductos();
        return new ResponseEntity<>(productos,HttpStatus.OK);
    }
    
}
