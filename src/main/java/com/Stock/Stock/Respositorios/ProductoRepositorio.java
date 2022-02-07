/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Stock.Stock.Entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author rnavas
 */
@Repository
public interface ProductoRepositorio  extends JpaRepository<Producto, Integer> {
    
     @Query(nativeQuery = true, value = "SELECT * from Producto where dtype Like ('Articulo')")
    public List<Producto> buscarArticulos();
   
     @Query(nativeQuery = true, value = "SELECT * from Producto where dtype Like ('ProductoStandar')")
    public List<Producto> buscarProductos();
    
     @Query(nativeQuery = true, value = "SELECT * from Producto where dtype Like ('ProductoCompuesto')")
    public List<Producto> buscarProductosCompuestos();
   
    
}
