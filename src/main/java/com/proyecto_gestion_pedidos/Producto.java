package com.proyecto_gestion_pedidos;


public abstract class Producto {
    protected static final double IVA_GENERAL = 0.21;
    private int id;
    private String nombre;
    private double precioBase;

    /**
     * Constructs a new abstract product.
     *
     * @param id product ID
     * @param nombre product name
     * @param precioBase base price
     * @throws IllegalArgumentException if precioBase is negative
     */
    public Producto(int id, String nombre, double precioBase) {
        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    /**
     * Gets product ID.
     *
     * @return product identifier
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets product ID.
     *
     * @param id identifier to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets product name.
     *
     * @return product name
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Sets product name.
     *
     * @param nombre name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets base price.
     *
     * @return base price value
     */
    public double getPrecioBase() {
        return this.precioBase;
    }

    /**
     * Sets base price.
     *
     * @param precioBase base price value to set
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Abstract method to calculate final price for the product.
     *
     * @return calculated price including tax
     */
    public abstract double calcularPrecioFinal();
}