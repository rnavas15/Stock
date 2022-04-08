/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import Enum.Categoria;
import Enum.UnidadesDeMedida;
import com.Stock.Stock.Entidades.Articulo;
import com.Stock.Stock.Entidades.DetalleGasto;
import com.Stock.Stock.Entidades.DetallePedido;
import com.Stock.Stock.Entidades.Lote;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Entidades.ProductoCompuesto;
import com.Stock.Stock.Entidades.ProductoStandar;
import com.Stock.Stock.Respositorios.ProductoRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author rnavas
 */
@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    FotoServicio fotoServicio;
    @Autowired
    IngredienteServicio ingredienteServicio;

    @Transactional
    public void crearProdEstandar(String fabricante, Integer stock, String nombre, Double costo, Double precioVenta, MultipartFile foto, String categoria) throws Exception {
        ProductoStandar P = new ProductoStandar();
        P.setFabricante(fabricante);
        P.setStock(0.0);
        P.setNombre(nombre);
        P.setCosto(costo);
        P.setFoto(fotoServicio.guardar(foto));
        P.setUnidad(UnidadesDeMedida.UN);
        P.setPrecioVenta(precioVenta);
        P.setCategoria(Categoria.valueOf(categoria));

        productoRepositorio.save(P);

    }

    @Transactional
    public void crearArticulo(String fabricante, Integer stock, String nombre, Double costo, Double precioVenta, MultipartFile foto, String categoria, String unidad) throws Exception {
        Articulo P = new Articulo();
        P.setFabricante(fabricante);
        P.setStock(0.0);
        P.setNombre(nombre);
        P.setCosto(costo);
        P.setFoto(fotoServicio.guardar(foto));
        P.setPrecioVenta(precioVenta);
        P.setCategoria(Categoria.valueOf(categoria));
        P.setUnidad(UnidadesDeMedida.valueOf(unidad));

        productoRepositorio.save(P);

    }

    @Transactional
    public void modificarArticulo(Integer id, String fabricante, Integer stock, String nombre, Double costo, Double precioVenta, MultipartFile foto, String categoria, String unidad) throws Exception {
        Articulo P = productoRepositorio.buscarArticulo(id);
        
        Double costoprevio=P.getCosto();
        System.out.println("ARTICULO COSTO PREVIO "+costoprevio);
                System.out.println("NUEVO COSTO  "+costo);

        P.setFabricante(fabricante);
        
        P.setNombre(nombre);
        P.setCosto(costo);
        if (!foto.isEmpty()) {
            P.setFoto(fotoServicio.guardar(foto));
        };
        P.setPrecioVenta(precioVenta);
        P.setCategoria(Categoria.valueOf(categoria));
        P.setUnidad(UnidadesDeMedida.valueOf(unidad));

        productoRepositorio.save(P);
        if (!costoprevio.equals(costo) ) {
                        System.out.println("COMPARO DISTINTOS");

            ingredienteServicio.modificarCostoIngredientes(id,costoprevio);
        }else{
            System.out.println("COMPARO IGUALES");
        }

    }
     @Transactional
    public void modificarProducto(Integer id, String fabricante, Integer stock, String nombre, Double costo, Double precioVenta, MultipartFile foto, String categoria) throws Exception {
        ProductoStandar P = productoRepositorio.buscarProductoStandar(id);
        
        Double costoprevio=P.getCosto();
    

        P.setFabricante(fabricante);
        P.setNombre(nombre);
        P.setCosto(costo);
        if (!foto.isEmpty()) {
            P.setFoto(fotoServicio.guardar(foto));
        };
        P.setPrecioVenta(precioVenta);
        P.setCategoria(Categoria.valueOf(categoria));
        P.setUnidad(UnidadesDeMedida.UN);

        productoRepositorio.save(P);
        

    }

    @Transactional
    public void modificarCostoProducto(ProductoCompuesto P) throws Exception {

        ProductoCompuesto Pr = productoRepositorio.buscarProductoCompuesto(P.getProdId());
        Pr.setCosto(P.getCosto());
        productoRepositorio.save(Pr);

    }

    @Transactional
    public void modificarStock(String id, String stock) throws Exception {

        productoRepositorio.modificarStock(Integer.valueOf(id), Double.valueOf(stock));

    }

    @Transactional
    public void modificarCosto(String id, String costo) throws Exception {

        productoRepositorio.modificarCosto(Integer.valueOf(id), Double.valueOf(costo));

    }

    @Transactional
    public void crearProductoCompuesto(String nombre, Double costo, Double precioVenta, MultipartFile foto, String categoria) throws Exception {
        ProductoCompuesto P = new ProductoCompuesto();

        P.setNombre(nombre);
        P.setCosto(costo);
        P.setFoto(fotoServicio.guardar(foto));
        P.setPrecioVenta(precioVenta);
        P.setCategoria(Categoria.valueOf(categoria));

        productoRepositorio.save(P);

    }

    @Transactional
    public void modificarProductoCompuesto(Integer id, String nombre, Double costo, Double precioVenta, MultipartFile foto, String categoria) throws Exception {
        ProductoCompuesto P = productoRepositorio.buscarProductoCompuesto(id);

        P.setNombre(nombre);
        P.setCosto(costo);
        if (!foto.isEmpty()) {
            P.setFoto(fotoServicio.guardar(foto));
        }
        P.setPrecioVenta(precioVenta);
        P.setCategoria(Categoria.valueOf(categoria));

        productoRepositorio.save(P);

    }

    @Transactional
    public void eliminarArticulo(Integer id) {
        ingredienteServicio.eliminarIngredientes(id);
        Articulo a = productoRepositorio.buscarArticulo(id);
        productoRepositorio.delete(a);

    }

    public List<Producto> buscarProductos() {
        List<Producto> productos = productoRepositorio.buscarProductos();
        return productos;

    }

    public List<Producto> buscarProductosStandar() {
        List<Producto> productos = productoRepositorio.buscarProductosStandar();
        return productos;

    }

    public List<Producto> buscarArticulos() {
        List<Producto> productos = productoRepositorio.buscarArticulos();
        return productos;

    }

//     public Producto buscarArticulo(Integer id) {
//        Optional <Producto> producto = productoRepositorio.findById(id);
//        if(producto.isPresent()){
//            Producto p=producto.get();
//            
//        }
//        return producto;
//
//    }
    public List<Producto> buscarProductosCompuestos() {
        List<Producto> productos = productoRepositorio.buscarProductosCompuestos();
        return productos;

    }

    public ProductoStandar buscarProductoStandar(Integer Id) {

        return productoRepositorio.buscarProductoStandar(Id);
    }

    public Articulo buscarArticulo(Integer Id) {

        return productoRepositorio.buscarArticulo(Id);
    }

    public Producto buscarProducto(Integer Id) {

        return productoRepositorio.getById(Id);
    }

    public String buscarTipoProducto(String id) {
        return productoRepositorio.buscarTipoProducto(id);

    }
}
