package com.proyecto_gestion_pedidos;

public class ProductoDigital extends Producto {

    private String tipoIva;

    /**
     * Constructs a digital product.
     *
     * @param id product identifier
     * @param nombre product name
     * @param precioBase base price
     * @param tipoIva VAT category string
     */
    public ProductoDigital(int id, String nombre, double precioBase, String tipoIva) {
        super(id, nombre, precioBase);
        this.tipoIva = tipoIva;
    }

    /**
     * Gets VAT type string.
     *
     * @return VAT category
     */
    public String getTipoIva() {
        return this.tipoIva;
    }

    /**
     * Sets VAT type string.
     *
     * @param tipoIva VAT category to set
     */
    public void setTipoIva(String tipoIva) {
        this.tipoIva = tipoIva;
    }

    /**
     * Applies dynamic VAT rate based on the assigned VAT category string.
     *
     * @return calculated total price with VAT
     */
    public double aplicarIVA() {
        double iva;
        switch (tipoIva.toUpperCase()) {
            case "GENERAL":
                iva = 0.21;
                break;
            case "REDUCIDO":
                iva = 0.10;
                break;
            case "SUPER":
                iva = 0.04;
                break;
            default:
                iva = 0.21;
        }
        return getPrecioBase() + (getPrecioBase() * iva);
    }

    /**
     * Calculates final total price.
     *
     * @return price after applying corresponding VAT
     */
    @Override
    public double calcularPrecioFinal() {
        return aplicarIVA();
    }
}