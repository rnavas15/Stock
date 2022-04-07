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
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer pedidoId;
    
    @Temporal(TemporalType.DATE)
    Date fechaPedido;
    
    @Temporal(TemporalType.DATE)
    Date fechaEntrega;
    
    @ManyToOne
    Cliente cliente;
   
    @OneToMany(mappedBy = "pedido")
    List<DetallePedido> detallePedido;
    
    
}
