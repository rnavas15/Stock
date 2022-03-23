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

        MovimientoStock movimiento = new MovimientoStock();

        if (tipo.toLowerCase().equals("productostandar")) {
            ps = productoServicio.buscarProductoStandar(Integer.valueOf(id));
            movimiento.setCantidadActual(ps.getStock());
            movimiento.setCantidadIng(Integer.valueOf(stock));

            movimiento.setFechaMov(new Date());
            movimiento.setCostoActual(ps.getCosto());
            movimiento.setCostoNuevo(ps.getCosto());

            movimiento.setProducto(ps);
            movimiento.setTipoMovimiento(TipoMovimiento.ACTUALIZACION);

        }
        if (tipo.toLowerCase().equals("articulo")) {
            a = productoServicio.buscarArticulo(Integer.valueOf(id));
            movimiento.setCantidadActual(a.getStock());
            movimiento.setCantidadIng(Integer.valueOf(stock));

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
}
