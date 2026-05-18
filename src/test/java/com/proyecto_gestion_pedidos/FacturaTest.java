package com.proyecto_gestion_pedidos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    @Test
    void facturaGeneraCodigo() {

        Factura factura = new Factura(100, 21, 0, 121);

        assertNotNull(factura.getCodigoFactura());
    }

    @Test
    void facturaContieneTotalCorrecto() {

        Factura factura = new Factura(100, 21, 0, 121);

        assertEquals(121, factura.getTotalFinal());
    }
}