/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import com.Stock.Stock.Entidades.DetalleGasto;
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
public interface DetalleGastoRepositorio extends JpaRepository<DetalleGasto, Integer>{
    @Query("SELECT p FROM DetalleGasto p WHERE p.detalleGastoId = :id")
    public DetalleGasto buscarDetalle(@Param("id") Integer id);
    
     @Query("SELECT p FROM DetalleGasto p WHERE p.gasto.gastoId = :id")
    public List<DetalleGasto> buscarDetalles(@Param("id") Integer id);

}
     