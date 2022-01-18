/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import com.Stock.Stock.Entidades.Lote;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Stock.Stock.Respositorios.LoteRepositorio;

/**
 *
 * @author rnavas
 */
@Service
public class LoteServicio {
    @Autowired
    LoteRepositorio loteRepositorio;
    
    public void crearLote(String nombre,Date fechaElaboracion,Date fechaVencimiento){
        Lote l=new Lote();
        l.setNombreLote(nombre);
        l.setFechaElab(fechaElaboracion);
        l.setFechaVto(fechaVencimiento);
        loteRepositorio.save(l);
        
    }
    
}
