/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import com.Stock.Stock.Entidades.Articulo;
import com.Stock.Stock.Entidades.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rnavas
 */
@Repository
public interface GastoRepositorio extends JpaRepository<Gasto, Integer>{
    
    
    
}
