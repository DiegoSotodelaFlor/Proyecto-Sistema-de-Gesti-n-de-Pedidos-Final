package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests unitarios de ProductoDigital.
 */
class ProductoDigitalTest {

    /**
     * Verifica cálculo correcto del IVA general.
     */
    @Test
    @DisplayName("Calculo correcto del IVA general")
    void ivaGeneralCorrecto() {

        ProductoDigital producto =
                new ProductoDigital(1, "Juego", 100, "GENERAL");

        assertEquals(
                121,
                producto.calcularPrecioFinal(),
                0.1,
                "El precio final debe ser 121"
        );
    }

    /**
     * Verifica que el precio final sea mayor
     * tras aplicar IVA.
     */
    @Test
    @DisplayName("Precio final mayor que precio base")
    void precioMayorQueOriginal() {

        ProductoDigital producto =
                new ProductoDigital(2, "Software", 50, "GENERAL");

        assertTrue(
                producto.calcularPrecioFinal() > 50,
                "El precio final debe ser mayor que el original"
        );
    }

    /**
     * Verifica que el precio final no sea igual
     * al precio base.
     */
    @Test
    @DisplayName("Error: precio final distinto al base")
    void precioNoIgual() {

        ProductoDigital producto =
                new ProductoDigital(3, "App", 100, "GENERAL");

        assertFalse(
                producto.calcularPrecioFinal() == 100,
                "El precio final no debe ser igual al precio base"
        );
    }

    /**
     * Verifica IVA reducido.
     */
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

    /**
     * Verifica IVA superreducido.
     */
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