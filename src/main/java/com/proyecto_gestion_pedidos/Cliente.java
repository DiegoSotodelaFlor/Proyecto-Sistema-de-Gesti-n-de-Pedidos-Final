package com.proyecto_gestion_pedidos;

public class Cliente {

    private int id;
    private String nombre;
    private int aniosAntiguedad;
    private boolean vip;
    private String pais;

    /**
     * Constructor de cliente.
     *
     * @param id identificador
     * @param nombre nombre del cliente
     * @param aniosAntiguedad años de antigüedad
     * @param vip indica si es VIP
     * @param pais país del cliente
     */
    public Cliente(int id, String nombre, int aniosAntiguedad, boolean vip, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.aniosAntiguedad = aniosAntiguedad;
        this.vip = vip;
        this.pais = pais;
    }
    // Getters y setters

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

    public int getAniosAntiguedad() {
        return this.aniosAntiguedad;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        this.aniosAntiguedad = aniosAntiguedad;
    }

    public boolean isVip() {
        return this.vip;
    }

    public boolean getVip() {
        return this.vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    

    /**
     * Calcula descuento de fidelidad.
     *
     * @return porcentaje de descuento
     */
    public double calcularDescuento() {
        //si es vip y tiene más de 4 años de antigüedad
        if (vip && aniosAntiguedad >= 5) {
            // descuento del 15%
            return 0.15;
        }
        //si solo es vip
        if (vip) {
            //descuento del 10%
            return 0.10;
        }
        //si solo tiene más de 4 años de antigüedad
        if (aniosAntiguedad >= 5) {
            //descuento del 5%
            return 0.05;
        }
        //si ni no se cumple ninguna no hay descuento
        return 0.0;
    }


    
}