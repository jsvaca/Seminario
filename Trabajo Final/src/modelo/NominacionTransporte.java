package modelo;

import java.util.Date;

public class NominacionTransporte {
    private int numero;
    private Date fecha;
    private int codigoCI;

    public NominacionTransporte(int numero, Date fecha, int codigoCI) {
        this.numero = numero;
        this.fecha = fecha;
        this.codigoCI = codigoCI;
    }

    public int getNumero() {
        return numero;
    }

    public Date  getFecha() {
        return fecha;
    }

    public int getCodigoCI() {
        return codigoCI;
    }
}
