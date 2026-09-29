package com.proyecto_gestion_pedidos;

/**
 * Represents a tangible physical product requiring physical shipping and weight
 * calculation.
 *
 * @author DAW Student
 * @version 1.0
 */
public class ProductoFisico extends Producto {

    /** Weight of the physical product in kilograms. */
    private double peso;

    /**
     * Constructs a physical product.
     *
     * @param id         product ID
     * @param nombre     product name
     * @param precioBase base price
     * @param peso       weight in kg
     */
    public ProductoFisico(int id, String nombre, double precioBase, double peso) {
        super(id, nombre, precioBase);
        this.peso = peso;
    }

    /**
     * Gets product weight.
     *
     * @return weight in kg
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Sets product weight.
     *
     * @param peso weight in kg to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Calculates shipping charges based on destination country name.
     * Spain: 0 €
     * France, Italy, Portugal: 5 
     * Other countries: 10 
     * 
     * @param pais destination country name
     * @return calculated shipping cost
     */
    public double calcularCosteEnvio(String pais) {
        switch (pais.toLowerCase()) {
            case "españa":
                return 0;
            case "francia":
            case "italia":
            case "portugal":
                return 5;
            default:
                return 10;
        }
    }

    /**
     * Calculates final total price with standard general VAT applied.
     *
     * @return final calculated price
     */
    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + (getPrecioBase() * IVA_GENERAL);
    }
}