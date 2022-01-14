/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import java.util.List;
import javax.persistence.Entity;
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
public class ProductoStandar extends Producto{
    
   private String fabricante;
   private Integer stock;

    public ProductoStandar(String fabricante, Integer stock, String nombre, Double costo, Double precioVenta, List<Movimiento> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido) {
        super(nombre, costo, precioVenta, movimiento, lote, detallesGasto, detallesPedido);
        this.fabricante = fabricante;
        this.stock = stock;
    }

  


    
    
}
