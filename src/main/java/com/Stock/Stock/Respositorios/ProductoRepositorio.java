/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import com.Stock.Stock.Entidades.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Entidades.ProductoCompuesto;
import com.Stock.Stock.Entidades.ProductoStandar;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import static org.springframework.web.servlet.function.RequestPredicates.param;
import static org.springframework.web.servlet.function.RequestPredicates.param;

/**
 *
 * @author rnavas
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

    @Query(nativeQuery = true, value = "SELECT * from Producto where dtype Like ('Articulo')")
    public List<Producto> buscarArticulos();

    @Query(nativeQuery = true, value = "SELECT * from Producto where dtype Like ('ProductoStandar')")
    public List<Producto> buscarProductosStandar();

    @Query(nativeQuery = true, value = "SELECT * from Producto where dtype Like ('ProductoStandar')or dtype Like ('Articulo')")
    public List<Producto> buscarProductos();

    @Query(nativeQuery = true, value = "SELECT * from Producto where dtype Like ('ProductoCompuesto')")
    public List<Producto> buscarProductosCompuestos();

    @Query("SELECT p FROM Producto p WHERE p.prodId = :id")
    public Articulo buscarArticulo(@Param("id") Integer id);
    
     @Query("SELECT p FROM Producto p WHERE p.prodId = :id")
    public Producto buscarProducto(@Param("id") Integer id);
    
      @Query("SELECT p FROM Producto p WHERE p.prodId = :id")
    public ProductoStandar buscarProductoStandar(@Param("id") Integer id);
      
  
  
        @Query(nativeQuery = true, value = "SELECT dtype from Producto where prod_id=?1")
    public String buscarTipoProducto(String id);

    @Query("SELECT p FROM Producto p WHERE p.prodId = :id")
    public ProductoCompuesto buscarProductoCompuesto(@Param("id") Integer id);

    
     
     @Modifying
@Query("update Producto u set u.stock = :stock  where u.prodId= :id")
 public void modificarStock(@Param("id") Integer id,@Param ("stock")Double stock);

   @Modifying
@Query("update Producto u set u.costo = :costo  where u.prodId= :id")
 public void modificarCosto(@Param("id") Integer id,@Param ("costo")Double costo);
}
 
