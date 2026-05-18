package com.proyecto_gestion_pedidos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegresionTest {

    @Test
    void regresionCalculoIVA() {

        // REGRESION:
        // Corrección tras error detectado
        // en cálculo de IVA general

        ProductoDigital producto =new ProductoDigital(1,"Curso", 100, "GENERAL");

        assertEquals(121, producto.calcularPrecioFinal());
    }
}