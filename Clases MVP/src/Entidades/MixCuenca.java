package Entidades;

public class MixCuenca {
    private Proveedor proveedor;
    private Cuenca cuenca;
    private float porcentaje;

    public MixCuenca(Proveedor proveedor, Cuenca cuenca, float porcentaje) {
        this.proveedor = proveedor;
        this.cuenca = cuenca;
        this.porcentaje = porcentaje;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Cuenca getCuenca() {
        return cuenca;
    }

    public void setCuenca(Cuenca cuenca) {
        this.cuenca = cuenca;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
}
