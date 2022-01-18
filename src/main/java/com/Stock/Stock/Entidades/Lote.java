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
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer loteId;
    String nombreLote;

    @Temporal(TemporalType.DATE)
    Date fechaElab;

    @Temporal(TemporalType.DATE)
    Date fechaVto;

    @ManyToOne
    @JoinColumn(name="IdLote")
    Producto producto;

}
