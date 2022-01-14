/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import Enum.Tipo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rnavas
 */
@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer movId;
    
    @ManyToOne
    Producto producto;
    
    Tipo tipo;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date fechaMovimiento;
    
    Double costo;
    
    
    
    
    
    
}
