package modelo;

import java.util.Date;

public class NominacionInyeccion {
    private int numero;
    private Date fecha;
    private int codigoCI;

    public NominacionInyeccion(int numero, Date fecha, int codigoCI) {
        this.numero = numero;
        this.fecha = fecha;
        this.codigoCI = codigoCI;
    }

    public int getNumero() {
        return numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCodigoCI() {
        return codigoCI;
    }
}
