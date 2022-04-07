/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.Cliente;
import com.Stock.Stock.Servicios.ClienteServicio;
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
@RequestMapping("/Pedido")
public class PedidoControlador {
    
    @Autowired
    ClienteServicio clienteServicio;
    
    @GetMapping("")
    public String Pedidos(ModelMap modelo){
        List<Cliente> c=clienteServicio.buscarClientes();
        modelo.put("clientes", c);
        
        
        return "/Principal/Pedidos";
    }
     @PostMapping("/crear-cliente")
    public String crearArticulo(ModelMap modelo, @RequestParam String nombre, @RequestParam(defaultValue = "0") Long CUIT) throws Exception {

        clienteServicio.crearCliente(CUIT, nombre);
        modelo.put("clientes", clienteServicio.buscarClientes());
        return "redirect:/Pedido";
    }

    @PostMapping("/modificar-cliente")
    public String modificarArticulo(ModelMap modelo, @RequestParam Integer id, @RequestParam String nombre, @RequestParam(defaultValue = "0") Long CUIT) throws Exception {

       clienteServicio.modificarCliente(CUIT, nombre, id);
        modelo.put("proveedores", clienteServicio.buscarClientes());
        return "redirect:/Pedido";
    }
    
}


    
//    @GetMapping("")
//    public String Proveedores(ModelMap modelo) {
//        List<Proveedor> p = proveedorServicio.buscarProveedores();
//        List<Gasto> g=gastoServicio.buscarGastos();
//      
//                modelo.put("proveedores", proveedorServicio.buscarProveedores());
//                modelo.put("gastos", g);
//
//        
//        return "/Proveedores/Proveedores";
//    }
//
//    @PostMapping("/crear-proveedor")
//    public String crearArticulo(ModelMap modelo, @RequestParam String nombre, @RequestParam(defaultValue = "0") Long CUIT) throws Exception {
//
//        proveedorServicio.crearProveedor(CUIT, nombre);
//        modelo.put("proveedores", proveedorServicio.buscarProveedores());
//        return "redirect:/Proveedor";
//    }
//
//    @PostMapping("/modificar-proveedor")
//    public String modificarArticulo(ModelMap modelo, @RequestParam Integer id, @RequestParam String nombre, @RequestParam(defaultValue = "0") Long CUIT) throws Exception {
//
//        proveedorServicio.modificarProveedor(CUIT, nombre, id);
//        modelo.put("proveedores", proveedorServicio.buscarProveedores());
//        return "redirect:/Proveedor";
//    }

