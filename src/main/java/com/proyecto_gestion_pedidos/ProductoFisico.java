package com.proyecto_gestion_pedidos;


public class ProductoFisico extends Producto {

    private double peso;

    public ProductoFisico(int id, String nombre, double precioBase, double peso) {
        super(id, nombre, precioBase);
        this.peso = peso;
    }
    //getters y setters

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Calcula el coste de envío.
     *
     * @param pais país destino
     * @return coste de envío
     */
    public double calcularCosteEnvio(String pais) {
        switch (pais.toLowerCase()) { //convertimos a minúscula
            //si el país es España el coste de envío es 0
            case "españa":
                return 0;
            //si el país es Francia, Italia o Portugal el coste de envío es 5
            case "francia", "italia", "portugal":
                return 5;
            //si el país es no es ninguno de los anteriores el coste de envío es 10
            default:
                return 10;
        }
    }
    /**
     * Calcula el precio final.
     *
     * @return precio final con iva aplicado
     */
    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + (getPrecioBase() * IVA_GENERAL);
    }
    
}