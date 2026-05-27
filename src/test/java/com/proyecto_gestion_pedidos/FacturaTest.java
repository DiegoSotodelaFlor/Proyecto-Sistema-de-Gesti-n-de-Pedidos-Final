package com.proyecto_gestion_pedidos;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FacturaTest {

  @Test
    void facturaGeneraCodigo() {
        Factura factura = new Factura(100, 21, 0, 121);
        assertNotNull(factura.getCodigoFactura());
        assertNotNull(factura.getFechaEmision());
    }

    @Test
    void facturaContieneTotalCorrecto() {
        Factura factura = new Factura(100, 21, 0, 121);
        assertEquals(121, factura.getTotalFinal());
    }

    @Test
    @DisplayName("Setters y Getters completos de Factura")
    void testFacturaSettersYGetters() {
        Factura factura = new Factura(10, 2, 0, 12);
        LocalDate fecha = LocalDate.of(2026, 12, 31);
        
        factura.setCodigoFactura("FACT-TEST");
        factura.setFechaEmision(fecha);
        factura.setTotalNeto(50.0);
        factura.setTotalIva(10.5);
        factura.setTotalEnvio(4.5);
        factura.setTotalFinal(65.0);

        assertEquals("FACT-TEST", factura.getCodigoFactura());
        assertEquals(fecha, factura.getFechaEmision());
        assertEquals(50.0, factura.getTotalNeto(), 0.001);
        assertEquals(10.5, factura.getTotalIva(), 0.001);
        assertEquals(4.5, factura.getTotalEnvio(), 0.001);
        assertEquals(65.0, factura.getTotalFinal(), 0.001);
        assertNotNull(factura.generarDesglose()); // Da cobertura al método de impresión string si existiera
    }
}