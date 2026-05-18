package com.proyecto_gestion_pedidos;

public class MainRobustez {

    public static void main(String[] args) {

        // Crear cliente
        Cliente cliente = new Cliente( 1,"Juan Pérez",6,true,"España");

        System.out.println("----- PRUEBA DE ROBUSTEZ ------");

        //Precio negativo
        try {

            System.out.println("\n--TEST 1-- Creando producto con precio negativo...");

            ProductoDigital productoErroneo =
                    new ProductoDigital( 10,"Juego Bug",-50.0, //precio inválido
                            "GENERAL"
                    );

            System.out.println("ERROR: No se lanzó excepción (fallo del sistema)");

        } catch (IllegalArgumentException e) {

            System.out.println("Excepción controlada capturada:");
            System.out.println("   " + e.getMessage());
        }

        //Pedido vacío
        
        try {

            System.out.println("\n--TEST 2-- Creando pedido vacío...");

            Pedido pedidoVacio = new Pedido(2002, cliente);

            System.out.println("Intentando procesar pedido vacío...");

            Tienda tienda = new Tienda();

            //Aquí debería fallar si el sistema está bien diseñado
            Factura factura = tienda.realizarVenta(cliente, pedidoVacio);

            System.out.println("ERROR: No se lanzó excepción (fallo del sistema)");
            System.out.println("Factura generada: " + factura.getCodigoFactura());

        } catch (IllegalStateException e) {

            System.out.println("Excepción controlada capturada:");
            System.out.println("   " + e.getMessage());
        }

        System.out.println("\n-----------FIN PRUEBA DE ROBUSTEZ---------");
    }
}