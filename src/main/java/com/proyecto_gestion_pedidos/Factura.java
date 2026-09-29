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
     * Constructs a Factura instance with auto-generated code and current date.
     *
     * @param totalNeto  net total amount
     * @param totalIva   VAT total amount
     * @param totalEnvio shipping cost amount
     * @param totalFinal final total price
     */
    public Factura(double totalNeto, double totalIva, double totalEnvio, double totalFinal) {
        this.codigoFactura = UUID.randomUUID().toString();
        this.fechaEmision = LocalDate.now();
        this.totalNeto = totalNeto;
        this.totalIva = totalIva;
        this.totalEnvio = totalEnvio;
        this.totalFinal = totalFinal;
    }

    /**
     * Gets the unique invoice code.
     *
     * @return invoice code UUID string
     */
    public String getCodigoFactura() {
        return this.codigoFactura;
    }

    /**
     * Sets the invoice code.
     *
     * @param codigoFactura invoice identifier to set
     */
    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    /**
     * Gets the invoice issue date.
     *
     * @return emission date
     */
    public LocalDate getFechaEmision() {
        return this.fechaEmision;
    }

    /**
     * Sets the invoice issue date.
     *
     * @param fechaEmision date of emission to set
     */
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Gets the net total amount.
     *
     * @return net price before taxes
     */
    public double getTotalNeto() {
        return this.totalNeto;
    }

    /**
     * Sets the net total amount.
     *
     * @param totalNeto net value to set
     */
    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }

    /**
     * Gets the VAT amount.
     *
     * @return VAT value
     */
    public double getTotalIva() {
        return this.totalIva;
    }

    /**
     * Sets the VAT amount.
     *
     * @param totalIva VAT total to set
     */
    public void setTotalIva(double totalIva) {
        this.totalIva = totalIva;
    }

    /**
     * Gets shipping charges.
     *
     * @return shipping cost
     */
    public double getTotalEnvio() {
        return this.totalEnvio;
    }

    /**
     * Sets shipping charges.
     *
     * @param totalEnvio shipping cost value to set
     */
    public void setTotalEnvio(double totalEnvio) {
        this.totalEnvio = totalEnvio;
    }

    /**
     * Gets the final total amount payable.
     *
     * @return final invoice amount
     */
    public double getTotalFinal() {
        return this.totalFinal;
    }

    /**
     * Sets the final total amount.
     *
     * @param totalFinal final total to set
     */
    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    /**
     * Generates a formatted textual summary breakdown of the invoice.
     *
     * @return multi-line string containing itemized financial totals
     */
    public String generarDesglose() {
        return """
                FACTURANeto: %.2f
                IVA: %.2f
                Envío: %.2f
                Total Final: %.2f
                """.formatted(totalNeto, totalIva, totalEnvio, totalFinal);
    }
}