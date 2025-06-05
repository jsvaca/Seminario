package Entidades;

public class Cuenca {

    private int codigo;
    private String sigle;
    private String denominacion;

    public Cuenca(int codigo, String sigle, String denominacion) {
        this.codigo = codigo;
        this.sigle = sigle;
        this.denominacion = denominacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
