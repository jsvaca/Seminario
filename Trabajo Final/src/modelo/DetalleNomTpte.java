package modelo;

public class DetalleNomTpte {
    private int codigoDetalle;
    private int nroNominacion;
    private int prioridad;
    private int nroContrato;
    private int volSolicitado;
    private int codigoProveedor;

    public DetalleNomTpte(int codigoDetalle, int nroNominacion, int prioridad,
                          int nroContrato, int volSolicitado, int codigoProveedor) {
        this.codigoDetalle = codigoDetalle;
        this.nroNominacion = nroNominacion;
        this.prioridad = prioridad;
        this.nroContrato = nroContrato;
        this.volSolicitado = volSolicitado;
        this.codigoProveedor = codigoProveedor;
    }

    public int getCodigoDetalle() {
        return codigoDetalle;
    }

    public int getNroNominacion() {
        return nroNominacion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getNroContrato() {
        return nroContrato;
    }

    public int getVolSolicitado() {
        return volSolicitado;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }
}


