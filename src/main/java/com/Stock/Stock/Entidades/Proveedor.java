/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rnavas
 */
@Entity
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer proveedorId;
    
    Long CUIT;
    String razonSocial;
    
    @Temporal(TemporalType.DATE)
    Date fechaAlta;
    
    @Temporal(TemporalType.DATE)
    Date fechaBaja;
    
    Boolean estado;
    
    
    
}
