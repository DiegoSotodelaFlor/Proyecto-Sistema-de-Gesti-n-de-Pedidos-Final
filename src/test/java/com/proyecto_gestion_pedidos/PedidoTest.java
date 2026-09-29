package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PedidoTest {

    /**
     * Verifica el cálculo correcto del total del pedido.
     */
    @Test
    @DisplayName("Calculo correcto del total del pedido")
    void totalPedido() {

        Cliente cliente = new Cliente(1, "Juan", 3, false, "España");

        Pedido pedido = new Pedido(1, cliente);

        ProductoDigital prodDig = new ProductoDigital(1, "Juego", 100, "GENERAL");

        ProductoFisico prodFis = new ProductoFisico(2, "Libro", 50, 2);

        pedido.agregarProducto(prodDig);
        pedido.agregarProducto(prodFis);

        assertTrue(pedido.calcularTotal() > 0,"El total del pedido debe ser mayor que 0");
    }

    /**
     * Verifica que un pedido nuevo empieza vacío.
     */
    @Test
    @DisplayName("Error: pedido sin productos")
    void pedidoVacio() {

        Cliente cliente = new Cliente(2, "Ana", 1, false, "España");

        Pedido pedido = new Pedido(2, cliente);

        assertEquals(0,pedido.getProductos().size(),"El pedido debe empezar sin productos");
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

        Cliente cliente = new Cliente(1, "Juan", 2, false, "España");

        Pedido pedido = new Pedido(1, cliente);

        assertThrows(IllegalStateException.class,pedido::calcularTotal);
    }

    /**
     * Verifica eliminación dinámica de productos.
     */
    @Test
    @DisplayName("Eliminar producto del pedido")
    void eliminarProductoPedido() {

        Cliente cliente = new Cliente(3, "Luis", 4, false, "España");

        Pedido pedido = new Pedido(3, cliente);

        ProductoDigital producto = new ProductoDigital(1, "Curso", 80, "REDUCIDO");

        pedido.agregarProducto(producto);

        pedido.eliminarProducto(producto);

        assertEquals(0, pedido.getProductos().size());
    }
    @Test
    @DisplayName("Pedido Internacional con Producto Físico")
    void totalPedidoInternacionalFisico() {
        // Forzamos a que el cliente sea de Francia para que sume el envío en el bucle del pedido
        Cliente clienteExtranjero = new Cliente(10, "Pierre", 0, false, "Francia");
        Pedido pedido = new Pedido(10, clienteExtranjero);

        // Producto Físico: Base 100 + IVA (21) = 121. Envío a Francia = 5. Total = 126
        ProductoFisico fisico = new ProductoFisico(1, "Mesa", 100, 15.0);
        pedido.agregarProducto(fisico);

        assertEquals(126.0, pedido.calcularTotal(), 0.001);
    }

    @Test
    @DisplayName("Getters y Setters de Pedido")
    void testGettersSettersPedido() {
        Cliente c1 = new Cliente(1, "A", 1, false, "España");
        Cliente c2 = new Cliente(2, "B", 2, false, "España");
        Pedido pedido = new Pedido(1, c1);
        
        pedido.setIdPedido(55);
        pedido.setCliente(c2);

        assertEquals(55, pedido.getIdPedido());
        assertEquals(c2, pedido.getCliente());
    }
}