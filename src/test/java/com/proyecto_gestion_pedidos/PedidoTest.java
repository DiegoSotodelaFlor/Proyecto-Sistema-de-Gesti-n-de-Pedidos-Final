package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests unitarios de Pedido.
 */
class PedidoTest {

    /**
     * Verifica el cálculo correcto del total del pedido.
     */
    @Test
    @DisplayName("Calculo correcto del total del pedido")
    void totalPedido() {

        Cliente cliente =
                new Cliente(1, "Juan", 3, false, "España");

        Pedido pedido = new Pedido(1, cliente);

        ProductoDigital prodDig =
                new ProductoDigital(1, "Juego", 100, "GENERAL");

        ProductoFisico prodFis =
                new ProductoFisico(2, "Libro", 50, 2);

        pedido.agregarProducto(prodDig);
        pedido.agregarProducto(prodFis);

        assertTrue(
                pedido.calcularTotal() > 0,
                "El total del pedido debe ser mayor que 0"
        );
    }

    /**
     * Verifica que un pedido nuevo empieza vacío.
     */
    @Test
    @DisplayName("Error: pedido sin productos")
    void pedidoVacio() {

        Cliente cliente =
                new Cliente(2, "Ana", 1, false, "España");

        Pedido pedido = new Pedido(2, cliente);

        assertEquals(
                0,
                pedido.getProductos().size(),
                "El pedido debe empezar sin productos"
        );
    }

    /**
     * Verifica excepción al calcular pedido vacío.
     *
     * REGRESION:
     * Corrección tras fallo en integración maestra.
     */
    @Test
    @DisplayName("Error: calcular total de pedido sin productos")
    void pedidoSinProductos() {

        Cliente cliente =
                new Cliente(1, "Juan", 2, false, "España");

        Pedido pedido = new Pedido(1, cliente);

        assertThrows(
                IllegalStateException.class,
                pedido::calcularTotal
        );
    }

    /**
     * Verifica eliminación dinámica de productos.
     */
    @Test
    @DisplayName("Eliminar producto del pedido")
    void eliminarProductoPedido() {

        Cliente cliente =
                new Cliente(3, "Luis", 4, false, "España");

        Pedido pedido = new Pedido(3, cliente);

        ProductoDigital producto =
                new ProductoDigital(1, "Curso", 80, "REDUCIDO");

        pedido.agregarProducto(producto);

        pedido.eliminarProducto(producto);

        assertEquals(0, pedido.getProductos().size());
    }
}