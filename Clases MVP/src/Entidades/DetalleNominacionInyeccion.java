package Entidades;

public class DetalleNominacionInyeccion {
    private int prioridad;
    private long volumenSolicitado;
    private long volumenAutorizado;
    private double precio;
    private String tipoGas;
    private Nominacion nominacion;

    public DetalleNominacionInyeccion(int prioridad, long volumenSolicitado, long volumenAutorizado,
                                      double precio, String tipoGas, Nominacion nominacion) {
        this.prioridad = prioridad;
        this.volumenSolicitado = volumenSolicitado;
        this.volumenAutorizado = volumenAutorizado;
        this.precio = precio;
        this.tipoGas = tipoGas;
        this.nominacion = nominacion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public long getVolumenSolicitado() {
        return volumenSolicitado;
    }

    public void setVolumenSolicitado(long volumenSolicitado) {
        this.volumenSolicitado = volumenSolicitado;
    }

    public long getVolumenAutorizado() {
        return volumenAutorizado;
    }

    public void setVolumenAutorizado(long volumenAutorizado) {
        this.volumenAutorizado = volumenAutorizado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoGas() {
        return tipoGas;
    }

    public void setTipoGas(String tipoGas) {
        this.tipoGas = tipoGas;
    }

    public Nominacion getNominacion() {
        return nominacion;
    }

    public void setNominacion(Nominacion nominacion) {
        this.nominacion = nominacion;
    }
}
