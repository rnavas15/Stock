/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import com.Stock.Stock.Entidades.Proveedor;
import com.Stock.Stock.Respositorios.ProveedorRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rnavas
 */
@Service
public class ProveedorServicio {

    @Autowired
    ProveedorRepositorio proveedorRepositorio;
@Transactional
    public void crearProveedor(Long CUIT, String razonSocial) {

        Proveedor p = new Proveedor();
        p.setCUIT(CUIT);
        p.setEstado(Boolean.TRUE);
        p.setFechaAlta(new Date());
        p.setRazonSocial(razonSocial);

        proveedorRepositorio.save(p);
    }
@Transactional
    public void modificarProveedor(Long CUIT, String razonSocial, Integer id) {

        Optional<Proveedor> p = proveedorRepositorio.findById(id);
        if (p.isPresent()) {
            Proveedor p1 = p.get();
            p1.setCUIT(CUIT);
            p1.setRazonSocial(razonSocial);

            proveedorRepositorio.save(p1);
        }
    }
    

    public List<Proveedor> buscarProveedores() {

        return proveedorRepositorio.findAll();
    }
    
    public Proveedor buscarProveedor(Integer id){
        return proveedorRepositorio.getById(id);
    }

}
