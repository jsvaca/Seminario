package modelo;

public class Cuenca {
    private int codigo;
    private String denominacion;
    private String sigla;

    public Cuenca(int codigo, String denominacion, String sigla) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.sigla = sigla;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public String toString(){
        return denominacion;
    }
}
