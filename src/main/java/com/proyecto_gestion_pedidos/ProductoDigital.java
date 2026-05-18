package com.proyecto_gestion_pedidos;

public class ProductoDigital extends Producto {

    private String tipoIva;

    public ProductoDigital(int id, String nombre, double precioBase, String tipoIva) {
        super(id, nombre, precioBase);
        this.tipoIva = tipoIva;
    }
    //getters y setters

    public String getTipoIva() {
        return this.tipoIva;
    }

    public void setTipoIva(String tipoIva) {
        this.tipoIva = tipoIva;
    }

    /**
     * Aplica IVA según tipo.
     *
     * @return precio con IVA
     */
    public double aplicarIVA() {
        //creamos la avriable iva
        double iva;
        switch (tipoIva.toUpperCase()) { //convertimos el iva a mayúsculas
            //si es GENERAL el iva es del 21%
            case "GENERAL":
                iva = 0.21;
                break; //TERMINA
            //si es REDUCIDO el iva es del 10%
            case "REDUCIDO":
                iva = 0.10;
                break; //TERMINA
            //si es SUPER el iva es del 4%
            case "SUPER":
                iva = 0.04;
                break; //TERMINA
            // por defecto el iva es del 21%
            default:
                iva = 0.21;
        }
        //devolvemos el precio base más el precio por el iva
        return getPrecioBase() + (getPrecioBase() * iva);
    }
    /**
     * Calcula el precio final.
     *
     * @return precio final con iva aplicado
     */
    @Override
    public double calcularPrecioFinal() {
        return aplicarIVA();
    }
}