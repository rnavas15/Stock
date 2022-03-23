/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import com.Stock.Stock.Entidades.Articulo;
import com.Stock.Stock.Entidades.Ingrediente;
import com.Stock.Stock.Entidades.ProductoCompuesto;
import com.Stock.Stock.Respositorios.IngredienteRepositorio;
import com.Stock.Stock.Respositorios.ProductoRepositorio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rnavas
 */
@Service
public class IngredienteServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    IngredienteRepositorio ingredienteRepositorio;
    @Autowired
    ProductoServicio productoServicio;


    @Transactional
    public void agregarIngredientes(List<Integer> articulos, String prodId, List<Double> cant) throws Exception {
        List<Ingrediente> ingredientes = ingredienteRepositorio.buscarIngredientesProducto(Integer.valueOf(prodId));

        ListIterator<Integer> artIterator = articulos.listIterator();
        ListIterator<Ingrediente> ingIterator = ingredientes.listIterator();
        ListIterator<Double> cantIterator=cant.listIterator();
        
        ProductoCompuesto P = productoRepositorio.buscarProductoCompuesto(Integer.valueOf(prodId));
       
        while (artIterator.hasNext()) {
            Integer in = artIterator.nextIndex();
            Integer n = artIterator.next();
            ingIterator = ingredientes.listIterator();
            System.out.println("Valor Art Buscado " + n);
            System.out.println("Valor indice Art" + in);

            while (ingIterator.hasNext()) {

                Ingrediente ing = ingIterator.next();
                
                int ingvalor = ing.getArticulo().getProdId();
                System.out.println("Valor de ingrediente EVALUADO" + ingvalor);
                if (ingvalor == n) {
                    System.out.println("ENCONTRADO");
                    

                    while (cantIterator.hasNext()) {
                        int cantindex = cantIterator.nextIndex();
                        System.out.println("Index CANT EVALUADO " + cantindex + " INDICE A BORRAR " + in);
                        if (cantindex == in) {
                            Double can=cantIterator.next();
                            ing.setCantidad(can);
                            cantIterator.remove();

                            break;
                        }
                        cantIterator.next();

                    }
                    ingIterator.remove();
                    artIterator.remove();
                }

            }

        }
     
         for (int i = 0; i < articulos.size(); i++) {
            Articulo A = productoRepositorio.buscarArticulo(articulos.get(i));
            double cantidad = Double.valueOf(cant.get(i));
            Ingrediente I = new Ingrediente();
            I.setArticulo(A);
            I.setCantidad(cantidad);
            I.setProductoCompuesto(P);
            ingredienteRepositorio.save(I);
            
        }
        for (Ingrediente ingrediente : ingredientes) {
            ingredienteRepositorio.delete(ingrediente);
            
        }
        List<Ingrediente> ingredientesActualizados = ingredienteRepositorio.buscarIngredientesProducto(Integer.valueOf(prodId));
        Double costo=0.0;
        for (Ingrediente ingredienteActualizado : ingredientesActualizados) {
           
                    costo+=ingredienteActualizado.getCantidad()*ingredienteActualizado.getArticulo().getCosto();
                          
        }
        P.setCosto(costo);

        productoServicio.modificarCostoProducto(P);
            
    }




public List<Ingrediente> buscarIngredientesProducto(String id) {

        return ingredienteRepositorio.buscarIngredientesProducto(Integer.valueOf(id));
    }
public List<Ingrediente> buscarIngredienteArticulo(Integer id) {

        return ingredienteRepositorio.buscarIngredientesProducto(Integer.valueOf(id));
    }
public void eliminarIngredientes(Integer id){
    List<Ingrediente>ingredientes=buscarIngredienteArticulo(id);
    for (Iterator<Ingrediente> iterator = ingredientes.iterator(); iterator.hasNext();) {
        Ingrediente next = iterator.next();
        ingredienteRepositorio.delete(next);
        
    }
}
}
