/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rnavas
 */
@Entity
@Data
@NoArgsConstructor

public abstract class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer prodId;
    protected String nombre;
    protected Double costo;
    protected Double precioVenta;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Categoria categoria;
    
    
    @OneToMany (mappedBy = "producto")          
    protected List<Movimiento> movimiento;
    
    @OneToMany (mappedBy = "producto")
    protected List<Lote> lote;

    @OneToMany (mappedBy = "producto")
    
    protected List<DetalleGasto> detallesGasto;
    
    @OneToMany (mappedBy = "producto")
    protected List<DetallePedido> detallesPedido;
    
    @OneToOne
    protected Foto foto;
    
    
    
    
    
    

    public Producto(String nombre, Double costo, Double precioVenta, List<Movimiento> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido) {
        this.nombre = nombre;
        this.costo = costo;
        this.precioVenta = precioVenta;
        this.movimiento = movimiento;
        this.lote = lote;
        this.detallesGasto = detallesGasto;
        this.detallesPedido = detallesPedido;
        
    }

 

    
   
    

}
