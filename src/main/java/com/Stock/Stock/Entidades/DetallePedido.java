/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class DetallePedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer detalleId;
    
    @ManyToOne
    Producto producto;
    
    @ManyToOne
    Pedido pedido;
    
    Integer cantidad;
    
    Double costo;
    
    Double precioDeVenta;
    
            
    
}
