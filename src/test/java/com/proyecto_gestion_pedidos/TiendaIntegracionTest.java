package com.proyecto_gestion_pedidos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiendaIntegrationTest {

    @Test
    void realizarVentaCorrectamente() {

        Cliente cliente = new Cliente(1, "Juan", 6, true, "España");

        Pedido pedido = new Pedido(1, cliente);

        ProductoDigital producto = new ProductoDigital(1, "Juego", 100, "GENERAL");

        pedido.agregarProducto(producto);

        Tienda tienda = new Tienda();

        Factura factura = tienda.realizarVenta(cliente, pedido);

        assertNotNull(factura);

        assertTrue(factura.getTotalFinal() > 0);
    }
}