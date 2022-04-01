/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import Enum.UnidadesDeMedida;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 *
 * @author rnavas
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoStandar extends Producto implements Serializable{
    
   private String fabricante;
   private Double stock;
    private Enum unidad;

    public ProductoStandar(String fabricante, Double stock, String nombre, Double costo, Double precioVenta, List<MovimientoStock> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido) {
        super(nombre, costo, precioVenta, movimiento, lote, detallesGasto, detallesPedido);
        this.fabricante = fabricante;
        this.stock = stock;
        this.unidad=UnidadesDeMedida.UN;
    }
   
  


    
    
}
