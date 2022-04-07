/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import Enum.TipoMovimiento;
import com.Stock.Stock.Entidades.Articulo;
import com.Stock.Stock.Entidades.MovimientoStock;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Entidades.ProductoStandar;
import com.Stock.Stock.Respositorios.StockRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rnavas
 */
@Service
public class StockServicio {

    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    StockRepositorio stockRepositorio;

    @Transactional
    public void registrarMovimiento(String id, String stock) throws Exception {
        ProductoStandar ps = new ProductoStandar();
        Articulo a = new Articulo();
        String tipo = productoServicio.buscarTipoProducto(id);
        System.out.println("STOCK "+ stock);
        System.out.println("STOCK "+ Double.valueOf(stock));


        MovimientoStock movimiento = new MovimientoStock();

        if (tipo.toLowerCase().equals("productostandar")) {
            ps = productoServicio.buscarProductoStandar(Integer.valueOf(id));
            movimiento.setCantidadActual(ps.getStock());
            movimiento.setCantidadIng((ps.getStock() - Double.valueOf(stock)));
            movimiento.setCantidadNueva((Double.valueOf(stock)));

            movimiento.setFechaMov(new Date());
            movimiento.setCostoActual(ps.getCosto());
            movimiento.setCostoNuevo(ps.getCosto());

            movimiento.setProducto(ps);
            movimiento.setTipoMovimiento(TipoMovimiento.ACTUALIZACION);

        }
        if (tipo.toLowerCase().equals("articulo")) {
            a = productoServicio.buscarArticulo(Integer.valueOf(id));
            movimiento.setCantidadActual(a.getStock());
            movimiento.setCantidadIng((a.getStock() - Double.valueOf(stock)));
            movimiento.setCantidadNueva(Double.valueOf(stock));

            movimiento.setFechaMov(new Date());
            movimiento.setCostoActual(a.getCosto());
            movimiento.setCostoNuevo(a.getCosto());

            movimiento.setProducto(a);
            movimiento.setTipoMovimiento(TipoMovimiento.ACTUALIZACION);

        }

        productoServicio.modificarStock(id, stock);
        stockRepositorio.save(movimiento);

    }

    public List<MovimientoStock> buscarMovimientos(Integer id) {
        return stockRepositorio.buscarMovimientos(id);

    }

    @Transactional
    public void registrarMovimientoCompra(Integer id, Double cant, Double monto) throws Exception {
        ProductoStandar ps = new ProductoStandar();
        Articulo a = new Articulo();
        String tipo = productoServicio.buscarTipoProducto(id.toString());

        MovimientoStock movimiento = new MovimientoStock();

        if (tipo.toLowerCase().equals("productostandar")) {
            ps = productoServicio.buscarProductoStandar(id);
            
            movimiento.setCantidadActual(ps.getStock());
            movimiento.setCantidadIng((cant));
             movimiento.setCantidadNueva((ps.getStock() + cant));
        Double cantidad=(ps.getStock() + cant);
        productoServicio.modificarStock(id.toString(),(cantidad).toString());

            movimiento.setFechaMov(new Date());
            movimiento.setCostoActual(ps.getCosto());
            try {
                movimiento.setCostoNuevo((monto / cant));
                ps.setCosto((monto / cant));
                  Double monto1=(monto / cant);
                 productoServicio.modificarCosto(id.toString(),monto1.toString());
               
            } catch (Exception e) {
                throw new Exception("Error al dividir el monto por la cantidad de productos ingresados REVISE LA CANTIDAD");
            }

            movimiento.setProducto(ps);
            movimiento.setTipoMovimiento(TipoMovimiento.COMPRA);
            

        }
        if (tipo.toLowerCase().equals("articulo")) {
            a = productoServicio.buscarArticulo(id);
            movimiento.setCantidadActual(a.getStock());
            movimiento.setCantidadIng(cant);
            movimiento.setCantidadNueva((a.getStock() + cant));
            Double cantidad=(a.getStock() + cant);
        a.setStock(cantidad);

            movimiento.setFechaMov(new Date());
            movimiento.setCostoActual(a.getCosto());
            try {
                movimiento.setCostoNuevo((monto / cant));
                a.setCosto((monto / cant));
                Double monto1=(monto / cant);
                 productoServicio.modificarCosto(id.toString(),monto1.toString());
            } catch (Exception e) {
                throw new Exception("Error al dividir el monto por la cantidad de productos ingresados REVISE LA CANTIDAD");
            }

            movimiento.setProducto(a);
            
            movimiento.setTipoMovimiento(TipoMovimiento.COMPRA);
            

        }

        stockRepositorio.save(movimiento);

    }
}
