/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rnavas
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Articulo extends Producto{
    
    private String fabricante;
    private Integer stock;
    private Enum unidad;
    
 
    
    
     @OneToMany(mappedBy = "articulo")          
    protected List<Ingrediente> ingrediente;
        
}
