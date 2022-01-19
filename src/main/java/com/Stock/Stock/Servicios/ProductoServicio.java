/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import com.Stock.Stock.Entidades.Categoria;
import com.Stock.Stock.Entidades.DetalleGasto;
import com.Stock.Stock.Entidades.DetallePedido;
import com.Stock.Stock.Entidades.Lote;
import com.Stock.Stock.Entidades.Movimiento;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Entidades.ProductoStandar;
import com.Stock.Stock.Respositorios.ProductoRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rnavas
 */
@Service
public class ProductoServicio {
    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    FotoServicio fotoServicio;
    
    
    @Transactional
    public void crearProdEstandar(String fabricante, Integer stock, String nombre, Double costo, Double precioVenta,MultipartFile foto,String categoria) throws Exception{
        ProductoStandar P= new ProductoStandar();
        P.setFabricante(fabricante);
        P.setStock(0);
        P.setNombre(nombre);
        P.setCosto(costo);
        P.setFoto(fotoServicio.guardar(foto));
        P.setPrecioVenta(precioVenta);
        P.setCategoria(Categoria.valueOf(categoria));
       
       
        
        
        
        productoRepositorio.save(P);
        
}
    public List<Producto> buscarProductos(){
        List<Producto> productos=productoRepositorio.findAll();
        return productos;
        
    }
    
    public Producto buscarProducto(Integer Id){
        
        return productoRepositorio.getById(Id);
    }
}
