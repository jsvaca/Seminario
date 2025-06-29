package modelo;

import java.util.Date;

public class Contrato {
    private int numero;
    private int codigoCI;
    private int codigoProveedor;
    private String tipo;
    private int volMax;
    private int volMin;
    private Date fechaDesde;
    private Date fechaHasta;
    private double precio;

    public Contrato(int numero, int codigoCI, int codigoProveedor, String tipo,
                    int volMax, int volMin, Date fechaDesde, Date fechaHasta, double precio) {
        this.numero = numero;
        this.codigoCI = codigoCI;
        this.codigoProveedor = codigoProveedor;
        this.tipo = tipo;
        this.volMax = volMax;
        this.volMin = volMin;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public int getCodigoCI() {
        return codigoCI;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVolMax() {
        return volMax;
    }

    public int getVolMin() {
        return volMin;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public double getPrecio() {
        return precio;
    }
}
