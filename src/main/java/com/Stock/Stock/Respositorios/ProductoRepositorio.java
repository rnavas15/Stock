/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Stock.Stock.Entidades.Producto;


/**
 *
 * @author rnavas
 */
@Repository
public interface ProductoRepositorio  extends JpaRepository<Producto, Integer> {
    
}
