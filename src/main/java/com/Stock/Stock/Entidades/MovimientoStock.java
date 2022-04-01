/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Entidades;

import Enum.TipoMovimiento;
import com.Stock.Stock.Entidades.Producto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.degrees;

/**
 *
 * @author rnavas
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovimientoStock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idMov;

    private Double cantidadIng;
    private Double cantidadActual;
    private Double cantidadNueva;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMov;

    private Enum tipoMovimiento;

    @ManyToOne
    @JsonBackReference
    private Producto producto;

    private Double costoNuevo;
    private Double costoActual;

}
