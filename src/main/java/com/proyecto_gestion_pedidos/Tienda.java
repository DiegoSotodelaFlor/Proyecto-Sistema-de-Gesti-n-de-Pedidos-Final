package com.proyecto_gestion_pedidos;

public class Tienda {

    /**
     * Realiza venta completa.
     *
     * @param cliente cliente
     * @param pedido pedido
     * @return factura generada
     */
    public Factura realizarVenta(Cliente cliente, Pedido pedido) {

        double totalBase = pedido.calcularTotal();

        double descuento = totalBase * cliente.calcularDescuento();

        double totalFinal = totalBase - descuento;

        double iva = totalBase * 0.21;

        double envio = 0;

        return new Factura(
                totalBase,
                iva,
                envio,
                totalFinal
        );
    }
}