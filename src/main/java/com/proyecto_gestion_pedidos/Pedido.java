package com.proyecto_gestion_pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List productos;

    /**
     * Constructs a new order for a given customer.
     *
     * @param idPedido unique order ID
     * @param cliente target customer
     */
    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    /**
     * Adds a product to the order list.
     *
     * @param producto product instance to add
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Removes a product from the order list.
     *
     * @param producto product instance to remove
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    /**
     * Calculates total price of all items in the order, including individual shipping for physical items.
     *
     * @return combined price total
     * @throws IllegalStateException if the order contains no products
     */
    public double calcularTotal() {
        if (productos.isEmpty()) {
            throw new IllegalStateException("Pedido sin productos");
        }
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularPrecioFinal();
            if (producto instanceof ProductoFisico) {
                ProductoFisico pf = (ProductoFisico) producto;
                total += pf.calcularCosteEnvio(cliente.getPais());
            }
        }
        return total;
    }

    /**
     * Gets order ID.
     *
     * @return order identifier
     */
    public int getIdPedido() {
        return this.idPedido;
    }

    /**
     * Sets order ID.
     *
     * @param idPedido identifier to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Gets assigned customer.
     *
     * @return customer object
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     * Sets customer for the order.
     *
     * @param cliente customer to assign
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Gets product list in order.
     *
     * @return list of products
     */
    public List getProductos() {
        return this.productos;
    }

    /**
     * Sets the list of products.
     *
     * @param productos list of products to set
     */
    public void setProductos(List productos) {
        this.productos = productos;
    }
}