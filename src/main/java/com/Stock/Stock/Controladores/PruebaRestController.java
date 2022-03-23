/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Controladores;

import Enum.Categoria;
import Enum.UnidadesDeMedida;
import com.Stock.Stock.Entidades.Articulo;
import com.Stock.Stock.Entidades.Ingrediente;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Servicios.IngredienteServicio;
import com.Stock.Stock.Servicios.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import static javax.management.Query.value;
import static javax.management.Query.value;
import static net.bytebuddy.implementation.FixedValue.value;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rnavas
 */
@RestController
@RequestMapping("/ingredientes")
public class PruebaRestController {

    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    IngredienteServicio ingredienteServicio;

    @RequestMapping(value = "/llenardata/{id}", method = RequestMethod.GET)
    public List<Ingrediente> llenardatos(ModelMap modelo,@PathVariable String id) {
        List<Ingrediente> L = ingredienteServicio.buscarIngredientesProducto(id);

        modelo.put("categorias", Categoria.values());
        modelo.put("articulos", productoServicio.buscarProductosCompuestos());
        modelo.put("unidades", UnidadesDeMedida.values());
        modelo.put("productos", productoServicio.buscarArticulos());
        return L;
    }

    @PostMapping(value = "/cargar-ingredientes")
    @ResponseStatus(HttpStatus.CREATED)

    public String cargarIngredientes(ModelMap modelo, @RequestParam String productoID, String ids, String cant) throws Exception {
        
        ArrayList<Double> cantidad = new ArrayList();
        ArrayList<Integer> id = new ArrayList();

        JSONObject temp;
        JSONArray arraycant = new JSONArray(cant);
        JSONArray arrayid = new JSONArray(ids);
        
    
        for (int i = 0; i < arraycant.length(); i++) {

            temp = arraycant.getJSONObject(i);
            cantidad.add(temp.getDouble("cantidad"));
        }
        for (int i = 0; i < arrayid.length(); i++) {

            temp = arrayid.getJSONObject(i);
            id.add(temp.getInt("id"));
        }

       System.out.println("ID "+ id+"\n Cantidad "+cantidad);
                
            
        
        
        ingredienteServicio.agregarIngredientes(id,productoID,cantidad);
        
        modelo.put("categorias", Categoria.values());
        modelo.put("unidades", UnidadesDeMedida.values());
        modelo.put("productos", productoServicio.buscarArticulos());
        return "Datos guardados";

    }
    
    

}
