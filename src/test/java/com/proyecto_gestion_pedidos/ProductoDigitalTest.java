package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ProductoDigitalTest {

    /**
     * Verifica cálculo correcto del IVA general.
     */
    @Test
    @DisplayName("Calculo correcto del IVA general")
    void ivaGeneralCorrecto() {

        ProductoDigital producto = new ProductoDigital(1, "Juego", 100, "GENERAL");

        assertEquals(121,producto.calcularPrecioFinal(),0.1,"El precio final debe ser 121");
    }

    /**
     * Verifica que el precio final sea mayor
     * tras aplicar IVA.
     */
    @Test
    @DisplayName("Precio final mayor que precio base")
    void precioMayorQueOriginal() {

        ProductoDigital producto = new ProductoDigital(2, "Software", 50, "GENERAL");

        assertTrue(producto.calcularPrecioFinal() > 50,"El precio final debe ser mayor que el original");
    }

    /**
     * Verifica que el precio final no sea igual
     * al precio base.
     */
    @Test
    @DisplayName("Error: precio final distinto al base")
    void precioNoIgual() {

        ProductoDigital producto = new ProductoDigital(3, "App", 100, "GENERAL");

        assertNotEquals(100, producto.calcularPrecioFinal(),"El precio final no debe ser igual al precio base");
    }

    /**
     * Verifica IVA reducido.
     */
    @Test
    @DisplayName("Calculo correcto del IVA reducido")
    void ivaReducidoCorrecto() {

        ProductoDigital producto = new ProductoDigital(4, "Ebook", 100, "REDUCIDO");

        assertEquals( 110,producto.calcularPrecioFinal(),0.1);
    }

    /**
     * Verifica IVA superreducido.
     */
    @Test
    @DisplayName("Calculo correcto del IVA superreducido")
    void ivaSuperReducidoCorrecto() {

        ProductoDigital producto = new ProductoDigital(5, "Revista", 100, "SUPER");

        assertEquals(104,producto.calcularPrecioFinal(),0.1);
    }
    @Test
    @DisplayName("Caso SUPER")
    void ivaSuperCorrecto() {
        ProductoDigital producto = new ProductoDigital(5, "Revista Digital", 100, "SUPER");
        assertEquals(104, producto.calcularPrecioFinal(), 0.1);
    }

    @Test
    @DisplayName("Ignorar mayúsculas/minúsculas")
    void ivaMinusculas() {
        ProductoDigital producto = new ProductoDigital(6, "Ebook", 100, "reducido");
        assertEquals(110, producto.calcularPrecioFinal(), 0.1);
    }

    @Test
    @DisplayName("Rama DEFAULT (IVA Desconocido aplica General)")
    void ivaDefaultDesconocido() {
        ProductoDigital producto = new ProductoDigital(7, "Token", 100, "INVENTADO");
        assertEquals(121, producto.calcularPrecioFinal(), 0.1);
    }

    @Test
    @DisplayName("Getters y Setters de ProductoDigital")
    void testGettersSettersDigital() {
        ProductoDigital producto = new ProductoDigital(1, "A", 10, "GENERAL");
        producto.setId(2);
        producto.setNombre("B");
        producto.setPrecioBase(20.0);
        producto.setTipoIva("SUPER");

        assertEquals(2, producto.getId());
        assertEquals("B", producto.getNombre());
        assertEquals(20.0, producto.getPrecioBase(), 0.001);
        assertEquals("SUPER", producto.getTipoIva());
    }
}