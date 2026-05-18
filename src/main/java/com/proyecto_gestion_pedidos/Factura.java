package com.proyecto_gestion_pedidos;

import java.time.LocalDate;
import java.util.UUID;

public class Factura {

    private String codigoFactura;
    private LocalDate fechaEmision;
    private double totalNeto;
    private double totalIva;
    private double totalEnvio;
    private double totalFinal;

    /**
     * Constructor factura.
     */
    public Factura(double totalNeto, double totalIva,
                   double totalEnvio, double totalFinal) {

        this.codigoFactura = UUID.randomUUID().toString();
        this.fechaEmision = LocalDate.now();
        this.totalNeto = totalNeto;
        this.totalIva = totalIva;
        this.totalEnvio = totalEnvio;
        this.totalFinal = totalFinal;
    }
    //getters y setters

    public String getCodigoFactura() {
        return this.codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public LocalDate getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotalNeto() {
        return this.totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }

    public double getTotalIva() {
        return this.totalIva;
    }

    public void setTotalIva(double totalIva) {
        this.totalIva = totalIva;
    }

    public double getTotalEnvio() {
        return this.totalEnvio;
    }

    public void setTotalEnvio(double totalEnvio) {
        this.totalEnvio = totalEnvio;
    }

    public double getTotalFinal() {
        return this.totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    /**
     * Devuelve desglose factura.
     *
     * @return desglose
     */
    public String generarDesglose() {

        return """
                FACTURA
                ----------------
                Neto: %.2f
                IVA: %.2f
                Envío: %.2f
                Total Final: %.2f
                """.formatted(totalNeto, totalIva, totalEnvio, totalFinal);
    }
}