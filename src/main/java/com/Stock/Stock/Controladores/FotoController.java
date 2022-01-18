/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Servicios.FotoServicio;
import com.Stock.Stock.Servicios.ProductoServicio;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Entidades.ProductoStandar;
import com.Stock.Stock.Respositorios.ProductoRepositorio;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nicolas
 */

@Controller
@RequestMapping(value = "/foto", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
public class FotoController {
    
    @Autowired
    private FotoServicio fotoServicio;
    
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
      private  ProductoRepositorio p;
    
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) throws IOException {
        
        Producto producto = new ProductoStandar() ;
        
        try {
             producto = productoServicio.buscarProducto(id);
        } catch (Exception e) {
            return null;
        }


        byte[] bytes = fotoServicio.obtenerBytes(producto.getFoto().getId());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
    
    
}
