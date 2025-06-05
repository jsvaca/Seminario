package Entidades;

public class Proveedor {
    private int codigo;
    private String tipo;
    private String razonSocial;
    private ReferenteProveedor referente;

    public Proveedor(int codigo, String tipo, String razonSocial, ReferenteProveedor referente) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.razonSocial = razonSocial;
        this.referente = referente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public ReferenteProveedor getReferente() {
        return referente;
    }

    public void setReferente(ReferenteProveedor referente) {
        this.referente = referente;
    }
}
