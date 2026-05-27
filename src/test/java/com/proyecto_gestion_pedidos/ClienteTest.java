package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    @DisplayName("Cliente VIP con antigüedad exacta límite")
    void testCalcularDescuentoVipLmite() {
        Cliente cliente = new Cliente(1, "Juan", 5, true, "España");
        assertEquals(0.15, cliente.calcularDescuento(), 0.001);
    }

    @Test
    @DisplayName("Cliente VIP pero novato")
    void testCalcularDescuentoVipNovato() {
        Cliente cliente = new Cliente(2, "Ana", 4, true, "España");
        assertEquals(0.1, cliente.calcularDescuento(), 0.001);
    }

    @Test
    @DisplayName("Cliente con años pero NO es VIP")
    void testCalcularDescuentoNoVip() {
        Cliente cliente = new Cliente(3, "Luis", 10, false, "España");
        assertEquals(0.05, cliente.calcularDescuento(), 0.001);
    }

    @Test
    @DisplayName("Getters, Setters y variables")
    void testGettersYSettersCliente() {
        Cliente cliente = new Cliente(1, "Original", 2, false, "Francia");
        
        cliente.setId(99);
        cliente.setNombre("Modificado");
        cliente.setAniosAntiguedad(8);
        cliente.setVip(true);
        cliente.setPais("Italia");

        assertEquals(99, cliente.getId());
        assertEquals("Modificado", cliente.getNombre());
        assertEquals(8, cliente.getAniosAntiguedad());
        assertTrue(cliente.isVip());
        assertTrue(cliente.getVip()); // Cubre ambos métodos generados automáticamente
        assertEquals("Italia", cliente.getPais());
    }
}