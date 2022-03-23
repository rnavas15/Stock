/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import com.Stock.Stock.Entidades.MovimientoStock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author rnavas
 */
@Repository
public interface StockRepositorio extends JpaRepository<MovimientoStock, Integer>{
    
    @Query("SELECT p FROM MovimientoStock p WHERE p.producto.prodId =:id ")
    public List<MovimientoStock> buscarMovimientos(@Param("id") Integer id);
    
    
}
