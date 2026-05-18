package com.proyecto_gestion_pedidos;

public class Main {

    public static void main(String[] args) {

        // Crear cliente
        Cliente cliente = new Cliente(1,"Juan Pérez",6,true,"España");

        // Crear productos
        ProductoDigital juegoDigital =
                new ProductoDigital(1,"God Of War",59.99,"GENERAL");

        ProductoFisico teclado =
                new ProductoFisico(2,"Teclado Mecánico",120.00,2.5);

        ProductoFisico monitor =
                new ProductoFisico(3,"Monitor Gaming",250.00,5);

        // Crear pedido
        Pedido pedido = new Pedido(1001, cliente);

        // Añadir productos al pedido
        pedido.agregarProducto(juegoDigital);
        pedido.agregarProducto(teclado);
        pedido.agregarProducto(monitor);

        // Mostrar productos añadidos
        System.out.println("----------PEDIDO----------");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("País: " + cliente.getPais());

        System.out.println("\nProductos:");

        for (Producto producto : pedido.getProductos()) {

            System.out.println(
                    "- " + producto.getNombre()
                            + " | Precio final: "
                            + String.format("%.2f €",
                            producto.calcularPrecioFinal())
            );

            // Mostrar envío solo si es producto físico
            if (producto instanceof ProductoFisico) {

                ProductoFisico pf = (ProductoFisico) producto;

                System.out.println(
                        "  Coste envío: "
                                + pf.calcularCosteEnvio(cliente.getPais())
                                + " €"
                );
            }
        }

        // Calcular total del pedido
        double totalPedido = pedido.calcularTotal();

        System.out.println("\nTotal pedido: "
                + String.format("%.2f €", totalPedido));

        // Realizar venta
        Tienda tienda = new Tienda();

        Factura factura = tienda.realizarVenta(cliente, pedido);

        // Mostrar factura
        System.out.println("\n***********FACTURA***********");
        System.out.println("Código factura: "
                + factura.getCodigoFactura());

        System.out.println("Fecha emisión: "
                + factura.getFechaEmision());

        System.out.println(
                factura.generarDesglose()
        );

    }
}