/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import com.Stock.Stock.Entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rnavas
 */
@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer>{
    
    
}
