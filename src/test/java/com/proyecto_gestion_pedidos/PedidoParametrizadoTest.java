package com.proyecto_gestion_pedidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests parametrizados para ProductoFisico.
 */
class PedidoParametrizadoTest {

    /**
     * Verifica el cálculo del precio final de productos físicos
     * con diferentes valores de precio base.
     *
     * REGRESION:
     * Añadido control de IVA tras fallo detectado en pruebas.
     *
     * @param precio precio base
     * @param esperado precio esperado con IVA
     */
    @ParameterizedTest
    @DisplayName("Calculo del precio final de producto fisico con diferentes valores")
    @CsvSource({
            "100, 121",
            "50, 60.5",
            "200, 242"
    })
    void calcularPrecioParametrizado(double precio, double esperado) {

        ProductoFisico producto = new ProductoFisico(1, "Producto", precio, 2.5);

        assertEquals(esperado, producto.calcularPrecioFinal(), 0.1,
                "El precio final debe coincidir con el calculado"
        );
    }
}