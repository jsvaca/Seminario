package modelo;

public class Proveedor {
    private int id;
    private String razonSocial;
    private String tipo;
    private int referente;

    public Proveedor(int id, String razonSocial, String tipo, int referente) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        this.referente = referente;
    }

    public int getId() {
        return id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getTipo() {
        return tipo;
    }

    public int getReferente() {
        return referente;
    }

    @Override
    public String toString(){
        return razonSocial;
    }
}
