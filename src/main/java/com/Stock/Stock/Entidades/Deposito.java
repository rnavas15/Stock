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
public class Deposito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer depositoId;
    Integer numeroDeposito;
    String nombre;
    String descripcion;
    
    
}
