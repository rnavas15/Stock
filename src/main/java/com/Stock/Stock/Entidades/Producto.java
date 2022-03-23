/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import Enum.Categoria;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public abstract class Producto implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer prodId;
    
    protected String nombre;
    protected Double costo;
    protected Double precioVenta;
    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    protected Categoria categoria;
    
    
    @OneToMany (mappedBy = "producto")    
    @JsonManagedReference
    protected List<MovimientoStock> movimiento;
    
    @OneToMany (mappedBy = "producto")
    protected List<Lote> lote;

    @OneToMany (mappedBy = "producto")
    
    protected List<DetalleGasto> detallesGasto;
    
    @OneToMany (mappedBy = "producto")
    protected List<DetallePedido> detallesPedido;

    @OneToOne
    protected Foto foto;

  
    
    
    
    
    
        public Producto(String nombre, Double costo, Double precioVenta, List<MovimientoStock> movimiento, List<Lote> lote, List<DetalleGasto> detallesGasto, List<DetallePedido> detallesPedido) {
        this.nombre = nombre;
        this.costo = costo;
        this.precioVenta = precioVenta;
        this.movimiento = movimiento;
        this.lote = lote;
        this.detallesGasto = detallesGasto;
        this.detallesPedido = detallesPedido;
        
    }

 

    
   
    

}
