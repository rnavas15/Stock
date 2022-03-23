/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;


import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Gasto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer gastoId;
    
    Double montoTotal;
    
    @OneToMany (mappedBy = "gasto")
    List<DetalleGasto> detalleGasto;
    
    @Temporal(TemporalType.DATE)
    Date fechaGasto;
    
    @ManyToOne
    Proveedor proveedor;
    
    
    
}
