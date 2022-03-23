/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Respositorios;

import com.Stock.Stock.Entidades.Ingrediente;
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
public interface IngredienteRepositorio extends JpaRepository<Ingrediente, Integer> {

    @Query("SELECT p FROM Ingrediente p WHERE p.productoCompuesto.prodId=:id")
    
    public List<Ingrediente> buscarIngredientesProducto(@Param("id") Integer id);
    
     @Query("SELECT p FROM Ingrediente p WHERE p.articulo.prodId=:id")
    
    public List<Ingrediente> buscarIngredienteArticulo(@Param("id") Integer id);
    
    

}
