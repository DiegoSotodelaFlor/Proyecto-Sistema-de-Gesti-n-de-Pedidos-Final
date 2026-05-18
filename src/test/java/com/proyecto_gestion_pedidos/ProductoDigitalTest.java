package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductoDigitalTest {

    @Test
    @DisplayName("Calculo correcto del IVA general")
    void ivaGeneralCorrecto() {

        ProductoDigital producto =
                new ProductoDigital(1, "Juego", 100, "GENERAL");

        assertEquals(121,
                producto.calcularPrecioFinal(),
                0.1);
    }

    @Test
    @DisplayName("Precio final mayor que precio base")
    void precioMayorQueOriginal() {

        ProductoDigital producto =
                new ProductoDigital(2, "Software", 50, "GENERAL");

        assertTrue(
                producto.calcularPrecioFinal() > 50
        );
    }

    @Test
    @DisplayName("Error: precio final distinto al base")
    void precioNoIgual() {

        ProductoDigital producto =
                new ProductoDigital(3, "App", 100, "GENERAL");

        assertFalse(
                producto.calcularPrecioFinal() == 100
        );
    }

    @Test
    @DisplayName("Calculo correcto del IVA reducido")
    void ivaReducidoCorrecto() {

        ProductoDigital producto =
                new ProductoDigital(4, "Ebook", 100, "REDUCIDO");

        assertEquals(
                110,
                producto.calcularPrecioFinal(),
                0.1
        );
    }

    @Test
    @DisplayName("Calculo correcto del IVA superreducido")
    void ivaSuperReducidoCorrecto() {

        ProductoDigital producto =
                new ProductoDigital(5, "Revista", 100, "SUPER");

        assertEquals(
                104,
                producto.calcularPrecioFinal(),
                0.1
        );
    }
}