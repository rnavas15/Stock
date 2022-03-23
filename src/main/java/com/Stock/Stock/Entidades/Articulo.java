/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import Enum.Categoria;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author rnavas
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Articulo extends Producto implements Serializable{
    
    private String fabricante;
    private Integer stock;
    private Enum unidad;
    
 
    
    
     @OneToMany(mappedBy = "articulo")   
     @JsonBackReference
    protected List<Ingrediente> ingrediente;

    public Articulo(String fabricante, Integer stock, Enum unidad, List<Ingrediente> ingrediente, String nombre, Double costo, Double precioVenta, List<MovimientoStock> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido) {
        super(nombre, costo, precioVenta, movimiento, lote, detallesGasto, detallesPedido);
        this.fabricante = fabricante;
        this.stock = stock;
        this.unidad = unidad;
        this.ingrediente = ingrediente;
    }

   

    public Articulo(String fabricante, Integer stock, Enum unidad, List<Ingrediente> ingrediente, Integer prodId, String nombre, Double costo, Double precioVenta, Categoria categoria, List<MovimientoStock> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido, Foto foto) {
        super(prodId, nombre, costo, precioVenta, categoria, movimiento, lote, detallesGasto, detallesPedido, foto);
        this.fabricante = fabricante;
        this.stock = stock;
        this.unidad = unidad;
        this.ingrediente = ingrediente;
    }

 

   
   
     
        
}
