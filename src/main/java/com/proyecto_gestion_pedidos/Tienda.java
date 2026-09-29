package com.proyecto_gestion_pedidos;

public class Tienda {

    /**
     * Processes a full sale for a customer order, calculating discounts, VAT, and generating a Factura.
     *
     * @param cliente customer making the purchase
     * @param pedido order being processed
     * @return generated Factura instance
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