package com.proyecto_gestion_pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idPedido;
    private Cliente cliente;
    private List<Producto> productos;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    /**
     * Añade producto al pedido.
     *
     * @param producto producto
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Elimina producto del pedido.
     *
     * @param producto producto
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    /**
     * Calcula total del pedido.
     *
     * @return total
     */
    public double calcularTotal() {

        if (productos.isEmpty()) {
            throw new IllegalStateException("Pedido sin productos");
        }
        //creamos la variable total
        double total = 0;
        //por cada producto
        for (Producto producto : productos) {
            //sumamos su precio final al precio tatl del pedido
            total += producto.calcularPrecioFinal();
            //
            if (producto instanceof ProductoFisico pf) {

                total += pf.calcularCosteEnvio(cliente.getPais());
            }
        }

        return total;
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}