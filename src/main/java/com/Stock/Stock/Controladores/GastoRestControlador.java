/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import com.Stock.Stock.Entidades.DetalleGasto;
import com.Stock.Stock.Entidades.Gasto;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Respositorios.ProductoRepositorio;
import com.Stock.Stock.Servicios.GastoServicio;
import com.Stock.Stock.Servicios.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rnavas
 */
@RestController
@RequestMapping("/Gasto")
public class GastoRestControlador {

    @Autowired
    ProductoServicio productoServicio;
     @Autowired
    GastoServicio gastoServicio;
        

    @RequestMapping(value = "/llenardata/", method = RequestMethod.GET)
    public List<Producto> llenardatos(ModelMap modelo) {
        return productoServicio.buscarProductos();
    }
    @RequestMapping(value = "/detalleGastos/{gastoId}", method = RequestMethod.GET)
    public List<DetalleGasto> detalleGastos(ModelMap modelo,@PathVariable String gastoId) {
        
        return gastoServicio.detalleGasto(Integer.valueOf(gastoId));
    }


    @PostMapping(value = "/cargar-gasto")
    @ResponseStatus(HttpStatus.CREATED)

    public void cargarGasto(ModelMap modelo, @RequestParam String proveedorId, String productoId, String cant, String monto) throws Exception {

        ArrayList<Double> cantidad = new ArrayList();
        ArrayList<Integer> id = new ArrayList();
        ArrayList<Double>monto1=new ArrayList();
        
        JSONObject temp;
        JSONArray arraycant = new JSONArray(cant);
        JSONArray arrayprodoductoId = new JSONArray(productoId);
        JSONArray arraymonto = new JSONArray(monto);
        
        for (Object object : arraymonto) {
            System.out.println("MONTO -- "+object);
            
        }
        
        for (Object object : arraycant) {
            System.out.println("CANT -- "+object);
            
        }
        for (Object object : arrayprodoductoId) {
            System.out.println("PRODUCTO -- "+object);
            
        }
        for (int i = 0; i < arraycant.length(); i++) {

            temp = arraycant.getJSONObject(i);
            cantidad.add(temp.getDouble("cantidad"));
        }
        for (int i = 0; i < arrayprodoductoId.length(); i++) {

            temp = arrayprodoductoId.getJSONObject(i);
            id.add(temp.getInt("id"));
        }
        for (int i = 0; i < arraymonto.length(); i++) {

            temp = arraymonto.getJSONObject(i);
            monto1.add(temp.getDouble("monto"));
        }


      gastoServicio.cargarGasto(proveedorId, id, cantidad, monto1);
//        for (int i = 0; i < arraycant.length(); i++) {
//
//            temp = arraycant.getJSONObject(i);
//            cantidad.add(temp.getDouble("cantidad"));
//        }
//        for (int i = 0; i < arrayid.length(); i++) {
//
//            temp = arrayid.getJSONObject(i);
//            id.add(temp.getInt("id"));
//        }
//
//        System.out.println("ID " + id + "\n Cantidad " + cantidad);
//
//        ingredienteServicio.agregarIngredientes(id, productoID, cantidad);
//
//        modelo.put("categorias", Categoria.values());
//        modelo.put("unidades", UnidadesDeMedida.values());
//        modelo.put("productos", productoServicio.buscarArticulos());
//        return "Datos guardados";

  }
    }
