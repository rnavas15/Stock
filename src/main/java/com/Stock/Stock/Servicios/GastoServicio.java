/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Stock.Stock.Servicios;

import Enum.TipoMovimiento;
import com.Stock.Stock.Entidades.Articulo;
import com.Stock.Stock.Entidades.DetalleGasto;
import com.Stock.Stock.Entidades.Gasto;
import com.Stock.Stock.Entidades.MovimientoStock;
import com.Stock.Stock.Entidades.Producto;
import com.Stock.Stock.Entidades.ProductoStandar;
import com.Stock.Stock.Entidades.Proveedor;
import com.Stock.Stock.Respositorios.DetalleGastoRepositorio;
import com.Stock.Stock.Respositorios.GastoRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rnavas
 */
@Service
public class GastoServicio {

    @Autowired
    DetalleGastoRepositorio detalleGastoRepositorio;
    @Autowired
    GastoRepositorio gastoRepositorio;
    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    ProveedorServicio proveedorServicio;
    @Autowired
    StockServicio stockServicio;

    public List<Gasto> buscarGastos() {
        return gastoRepositorio.findAll();

    }
    public List<DetalleGasto> detalleGasto(Integer id){
        return detalleGastoRepositorio.buscarDetalles(id);
    }

    @Transactional
    public void cargarGasto(String proveedorId, List<Integer> productoId, List<Double> cant, List<Double> monto) throws Exception {
        List<DetalleGasto> listagastos = new ArrayList();
        Gasto gasto = new Gasto();
        gasto.setProveedor(proveedorServicio.buscarProveedor(Integer.valueOf(proveedorId)));
        gasto.setMontoTotal(0.0);
        gasto.setFechaGasto(new Date());
        gasto.setDetalleGasto(listagastos);
        gastoRepositorio.save(gasto);

        Double montotot = 0.0;

        List<Producto> productos = new ArrayList<>();
        for (int i = 0; i < productoId.size(); i++) {
            String tipo = productoServicio.buscarTipoProducto(productoId.get(i).toString());
            if (tipo.toLowerCase().equals("productostandar")) {

                DetalleGasto detalle = new DetalleGasto();
                detalle.setCantidad(cant.get(i));

                detalle.setProducto(productoServicio.buscarProductoStandar(productoId.get(i)));
                detalle.setCosto(monto.get(i));
                montotot += monto.get(i);
                detalle.setGasto(gasto);
                detalleGastoRepositorio.save(detalle);
                listagastos.add(detalle);
                stockServicio.registrarMovimientoCompra(productoId.get(i), cant.get(i), monto.get(i));

            } else if (tipo.toLowerCase().equals("articulo")) {
                DetalleGasto detalle = new DetalleGasto();
                detalle.setCantidad(cant.get(i));

                detalle.setProducto(productoServicio.buscarArticulo(productoId.get(i)));
                detalle.setCosto(monto.get(i));
                montotot += monto.get(i);
                detalle.setGasto(gasto);

                detalleGastoRepositorio.save(detalle);

                listagastos.add(detalle);
                stockServicio.registrarMovimientoCompra(productoId.get(i), cant.get(i), monto.get(i));

            } else {
                throw new Exception("No se encuentra el producto ID " + productoId.get(i));
            }

        }
        gasto.setDetalleGasto(listagastos);
        gasto.setMontoTotal(montotot);
        gastoRepositorio.save(gasto);

    }
}
