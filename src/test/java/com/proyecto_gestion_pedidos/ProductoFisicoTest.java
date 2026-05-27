package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ProductoFisicoTest {

    /**
     * Verifica cálculo correcto del IVA.
     */
    @Test
    @DisplayName("Calculo correcto de IVA")
    void calculoCorrecto() {

        ProductoFisico producto = new ProductoFisico(1, "Libro", 100, 2);

        assertEquals(121,producto.calcularPrecioFinal(),0.1,"El precio final debe ser 121");
    }

    /**
     * Verifica coste de envío en España.
     */
    @Test
    @DisplayName("Coste envio España")
    void envioEspana() {

        ProductoFisico producto = new ProductoFisico(2, "Teclado", 100, 5);

        assertEquals(0,producto.calcularCosteEnvio("España"));
    }

    /**
     * Verifica coste de envío en Francia.
     */
    @Test
    @DisplayName("Coste envio Francia")
    void envioFrancia() {

        ProductoFisico producto = new ProductoFisico(3, "Monitor", 100, 5);

        assertEquals(5,producto.calcularCosteEnvio("Francia"));
    }

    /**
     * Verifica coste de envío internacional.
     */
    @Test
    @DisplayName("Coste envio internacional")
    void envioInternacional() {

        ProductoFisico producto = new ProductoFisico(4, "Portatil", 100, 5);

        assertEquals(10,producto.calcularCosteEnvio("USA"));
    }

    /**
     * Verifica que el precio final sea mayor
     * que el precio base.
     */
    @Test
    @DisplayName("Precio final mayor que precio base")
    void precioMayor() {

        ProductoFisico producto = new ProductoFisico(5, "Raton", 100, 1);

        assertTrue(producto.calcularPrecioFinal() > 100,"El precio final debe ser mayor");
    }

    /**
     * Verifica que el precio final no coincida
     * con el precio base.
     */
    @Test
    @DisplayName("Error: precio final distinto al base")
    void precioNoIgualBase() {

        ProductoFisico producto = new ProductoFisico(6, "Auriculares", 100, 1);

        assertNotEquals(100,producto.calcularPrecioFinal());
    }

    /**
     * Verifica excepción por precio negativo
     */
    @Test
    @DisplayName("Error: producto con precio negativo")
    void productoPrecioNegativo() {

        assertThrows(
                IllegalArgumentException.class,() -> new ProductoFisico(7,"Libro",-10,5));
    }
    @Test
    @DisplayName("Envío a Italia")
    void envioItalia() {
        ProductoFisico producto = new ProductoFisico(10, "Item", 100, 5);
        assertEquals(5, producto.calcularCosteEnvio("Italia"));
    }

    @Test
    @DisplayName("Envío a Portugal en minúsculas")
    void envioPortugalMinuscula() {
        ProductoFisico producto = new ProductoFisico(11, "Item", 100, 5);
        assertEquals(5, producto.calcularCosteEnvio("portugal"));
    }

    @Test
    @DisplayName("Getter y Setter de Peso")
    void testGetterSetterPeso() {
        ProductoFisico producto = new ProductoFisico(12, "Caja", 10.0, 1.5);
        producto.setPeso(4.75);
        assertEquals(4.75, producto.getPeso(), 0.001);
    }
}