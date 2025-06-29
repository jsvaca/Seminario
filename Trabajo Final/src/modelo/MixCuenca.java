package modelo;

public class MixCuenca {
    private int codigoProveedor;
    private int codigoCuenca;
    private double porcentaje;

    public MixCuenca(int codigoProveedor, int codigoCuenca, double porcentaje) {
        this.codigoProveedor = codigoProveedor;
        this.codigoCuenca = codigoCuenca;
        this.porcentaje = porcentaje;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public int getCodigoCuenca() {
        return codigoCuenca;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
