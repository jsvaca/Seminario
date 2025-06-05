package Entidades;

import java.time.LocalDate;

public class Contrato {
    private int numeroContrato;
    private String tipoContrata;
    private long volumenMaximo;
    private long volumenMinimo;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private double precio;
    private ComplejoIndustrial ci;
    private Proveedor proveedor;

    public Contrato(int numeroContrato, String tipoContrata, long volumenMaximo, long volumenMinimo,
                    LocalDate fechaDesde, LocalDate fechaHasta, double precio, ComplejoIndustrial ci,
                    Proveedor proveedor) {
        this.numeroContrato = numeroContrato;
        this.tipoContrata = tipoContrata;
        this.volumenMaximo = volumenMaximo;
        this.volumenMinimo = volumenMinimo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.precio = precio;
        this.ci = ci;
        this.proveedor = proveedor;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getTipoContrata() {
        return tipoContrata;
    }

    public void setTipoContrata(String tipoContrata) {
        this.tipoContrata = tipoContrata;
    }

    public long getVolumenMaximo() {
        return volumenMaximo;
    }

    public void setVolumenMaximo(long volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }

    public long getVolumenMinimo() {
        return volumenMinimo;
    }

    public void setVolumenMinimo(long volumenMinimo) {
        this.volumenMinimo = volumenMinimo;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ComplejoIndustrial getCi() {
        return ci;
    }

    public void setCi(ComplejoIndustrial ci) {
        this.ci = ci;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
