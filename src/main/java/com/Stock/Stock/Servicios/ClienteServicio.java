/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import com.Stock.Stock.Entidades.Cliente;
import com.Stock.Stock.Respositorios.ClienteRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 
 * @author rnavas
 */
@Service
public class ClienteServicio {
      @Autowired
    ClienteRepositorio clienteRepositorio;
@Transactional
    public void crearCliente(Long CUIT, String razonSocial) {

        Cliente c = new Cliente();
        
        
        c.setCUIT(CUIT);
        c.setEstado(Boolean.TRUE);
        c.setFechaAlta(new Date());
        c.setRazonSocial(razonSocial);
        c.setEstado(Boolean.TRUE);
        clienteRepositorio.save(c);
    }
@Transactional
    public void modificarCliente(Long CUIT, String razonSocial, Integer id) {

        Optional<Cliente> c = clienteRepositorio.findById(id);
        if (c.isPresent()) {
            Cliente c1 = c.get();
            c1.setCUIT(CUIT);
            c1.setRazonSocial(razonSocial);

            clienteRepositorio.save(c1);
        }
    }
    

    public List<Cliente> buscarClientes() {

        return clienteRepositorio.findAll();
    }
    
    public Cliente buscarCliente(Integer id){
        return clienteRepositorio.getById(id);
    }
    
    
    
    @Transactional
    public void altaBajaCliente(String id){
        
        Cliente c=clienteRepositorio.getById(Integer.valueOf(id));
        

        if(c.getEstado()){
         
            c.setEstado(Boolean.FALSE);
            

        }else{
            c.setEstado(Boolean.TRUE);
        }
        clienteRepositorio.save(c);
    }
    
}
