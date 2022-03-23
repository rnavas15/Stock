/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.Proveedor;
import com.Stock.Stock.Servicios.ProveedorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rnavas
 */
@Controller
@RequestMapping("/Proveedor")
public class ProveedorControlador {

    @Autowired
    ProveedorServicio proveedorServicio;

    @GetMapping("")
    public String Proveedores(ModelMap modelo) {
        List<Proveedor> p = proveedorServicio.buscarProveedores();
        for (Proveedor proveedor : p) {
            System.out.println(proveedor.getProveedorId());

        }
                modelo.put("proveedores", proveedorServicio.buscarProveedores());

        System.out.println(proveedorServicio.buscarProveedores().toString());
        return "/Proveedores/Proveedores";
    }

    @PostMapping("/crear-proveedor")
    public String crearArticulo(ModelMap modelo, @RequestParam String nombre, @RequestParam(defaultValue = "0") Long CUIT) throws Exception {

        proveedorServicio.crearProveedor(CUIT, nombre);
        modelo.put("proveedores", proveedorServicio.buscarProveedores());
        return "redirect:/Proveedor";
    }

    @PostMapping("/modificar-proveedor")
    public String modificarArticulo(ModelMap modelo, @RequestParam Integer id, @RequestParam String nombre, @RequestParam(defaultValue = "0") Long CUIT) throws Exception {

        proveedorServicio.modificarProveedor(CUIT, nombre, id);
        modelo.put("proveedores", proveedorServicio.buscarProveedores());
        return "redirect:/Proveedor";
    }

}
