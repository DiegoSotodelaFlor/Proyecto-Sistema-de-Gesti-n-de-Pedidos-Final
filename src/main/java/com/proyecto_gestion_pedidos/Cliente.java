package com.proyecto_gestion_pedidos;


public class Cliente {
    private int id;
    private String nombre;
    private int aniosAntiguedad;
    private boolean vip;
    private String pais;

    /**
     * Constructs a new Cliente instance with full parameters.
     *
     * @param id              customer identification number
     * @param nombre          full name of the customer
     * @param aniosAntiguedad years of customer loyalty
     * @param vip             true if the customer is a VIP, false otherwise
     * @param pais            country of residence
     */
    public Cliente(int id, String nombre, int aniosAntiguedad, boolean vip, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.aniosAntiguedad = aniosAntiguedad;
        this.vip = vip;
        this.pais = pais;
    }

    /**
     * Gets the customer ID.
     *
     * @return the customer identifier
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the customer ID.
     *
     * @param id the unique customer identifier to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the customer name.
     *
     * @return the name of the customer
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Sets the customer name.
     *
     * @param nombre the name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the years of seniority.
     *
     * @return number of years as customer
     */
    public int getAniosAntiguedad() {
        return this.aniosAntiguedad;
    }

    /**
     * Sets the years of seniority.
     *
     * @param aniosAntiguedad years of registration to set
     */
    public void setAniosAntiguedad(int aniosAntiguedad) {
        this.aniosAntiguedad = aniosAntiguedad;
    }

    /**
     * Checks if the customer is VIP.
     *
     * @return true if VIP status is active, false otherwise
     */
    public boolean isVip() {
        return this.vip;
    }

    /**
     * Gets VIP status flag.
     *
     * @return boolean flag indicating VIP status
     */
    public boolean getVip() {
        return this.vip;
    }

    /**
     * Sets VIP status for the customer.
     *
     * @param vip status flag to set
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * Gets customer country.
     *
     * @return country name
     */
    public String getPais() {
        return this.pais;
    }

    /**
     * Sets customer country.
     *
     * @param pais country name to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Calculates the loyalty discount percentage based on VIP status and seniority.
     **
     * @return discount percentage as a double value between 0.0 and 0.15
     */
    public double calcularDescuento() {
        if (vip && aniosAntiguedad >= 5) {
            return 0.15;
        }
        if (vip) {
            return 0.10;
        }
        if (aniosAntiguedad >= 5) {
            return 0.05;
        }
        //si ni no se cumple ninguna no hay descuento
        return 0;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", aniosAntiguedad='" + getAniosAntiguedad() + "'" +
            ", vip='" + isVip() + "'" +
            ", pais='" + getPais() + "'" +
            "}";
    }
    
}