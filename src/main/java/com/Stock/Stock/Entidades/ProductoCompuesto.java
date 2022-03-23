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
public class ProductoCompuesto extends Producto implements Serializable{

   
    @OneToMany(mappedBy = "productoCompuesto")
    @JsonBackReference
    private List<Ingrediente> ingrediente;

   
   
   

    public ProductoCompuesto(String nombre, Double costo, Double precioVenta, List<MovimientoStock> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido) {
        super(nombre, costo, precioVenta, movimiento, lote, detallesGasto, detallesPedido);
    }


    public ProductoCompuesto(Integer prodId, String nombre, Double costo, Double precioVenta, Categoria categoria, List<MovimientoStock> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido, Foto foto) {
        super(prodId, nombre, costo, precioVenta, categoria, movimiento, lote, detallesGasto, detallesPedido, foto);
    }
            
    
}
