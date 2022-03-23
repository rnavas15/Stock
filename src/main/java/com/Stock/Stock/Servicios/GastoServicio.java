/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import com.Stock.Stock.Entidades.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rnavas
 */
@Service
public class GastoServicio {
    
    @Autowired
    ProductoServicio productoServicio;
    public List<Producto> buscarProductos(){
        return productoServicio.buscarProductos();
        
    }
    
    
}
