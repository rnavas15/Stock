/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import com.Stock.Stock.Entidades.DetalleGasto;
import com.Stock.Stock.Entidades.DetallePedido;
import com.Stock.Stock.Entidades.Lote;
import com.Stock.Stock.Entidades.Movimiento;
import com.Stock.Stock.Entidades.ProductoStandar;
import com.Stock.Stock.Respositorios.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rnavas
 */
@Service
public class ProductoServicio {
    @Autowired
    ProductoRepositorio productoRepositorio;
    
    public void CrearProdEstandar(String fabricante, Integer stock, String nombre, Double costo, Double precioVenta, List<Movimiento> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido){
        ProductoStandar P= new ProductoStandar();
        P.setFabricante(fabricante);
        P.setStock(0);
        P.setNombre(nombre);
        P.setCosto(costo);
        P.setLote(lote);
        P.setPrecioVenta(precioVenta);
        
        productoRepositorio.save(P);
        
}
}
