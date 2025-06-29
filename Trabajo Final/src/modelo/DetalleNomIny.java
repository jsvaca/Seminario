package modelo;

public class DetalleNomIny {
    private int nroIny;
    private int nroNominacion;
    private int nroContrato;
    private int nroProveedor;
    private int nroCuenca;
    private int prioridad;
    private int volSolicitado;
    private int volAutorizado;
    private String tipoGas;
    private double precio;

    public DetalleNomIny(int nroIny, int nroNominacion, int nroContrato, int nroProveedor, int nroCuenca,
                         int prioridad, int volSolicitado, int volAutorizado, String tipoGas, double precio) {
        this.nroIny = nroIny;
        this.nroNominacion = nroNominacion;
        this.nroContrato = nroContrato;
        this.nroProveedor = nroProveedor;
        this.nroCuenca = nroCuenca;
        this.prioridad = prioridad;
        this.volSolicitado = volSolicitado;
        this.volAutorizado = volAutorizado;
        this.tipoGas = tipoGas;
        this.precio = precio;
    }

    public int getNroIny() {
        return nroIny;
    }

    public int getNroNominacion() {
        return nroNominacion;
    }

    public int getNroContrato() {
        return nroContrato;
    }

    public int getNroProveedor() {
        return nroProveedor;
    }

    public int getNroCuenca() {
        return nroCuenca;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getVolSolicitado() {
        return volSolicitado;
    }

    public int getVolAutorizado() {
        return volAutorizado;
    }

    public String getTipoGas() {
        return tipoGas;
    }

    public double getPrecio() {
        return precio;
    }
}
