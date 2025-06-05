package Entidades;

public class DetalleNominacionTpte {
    private int prioridad;
    private long volumenSolicitado;
    private long volumenAutorizado;
    private Nominacion nominacion;

    public DetalleNominacionTpte(int prioridad, long volumenSolicitado, long volumenAutorizado,
                                 Nominacion nominacion) {
        this.prioridad = prioridad;
        this.volumenSolicitado = volumenSolicitado;
        this.volumenAutorizado = volumenAutorizado;
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

    public Nominacion getNominacion() {
        return nominacion;
    }

    public void setNominacion(Nominacion nominacion) {
        this.nominacion = nominacion;
    }
}
