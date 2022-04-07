/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import com.Stock.Stock.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rnavas
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    
}
