package com.proyecto_gestion_pedidos;

public abstract class Producto {

    protected static final double IVA_GENERAL = 0.21;

    private int id;
    private String nombre;
    private double precioBase;

    /**
     * Constructor de producto.
     *
     * @param id identificador
     * @param nombre nombre
     * @param precioBase precio base
     */
    public Producto(int id, String nombre, double precioBase) {
        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }
    //Getters y setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return this.precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    

    /**
     * Calcula el precio final.
     *
     * @return precio final
     */
    public abstract double calcularPrecioFinal();
}