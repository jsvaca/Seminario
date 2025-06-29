package modelo;

public class CI {
    private int id;
    private String razonSocial;
    private String ubicacion;
    private int referente;

    public CI(int id, String razonSocial, String ubicacion, int referente) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.ubicacion = ubicacion;
        this.referente = referente;
    }

    public int getId() {
        return id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getReferente() {
        return referente;
    }

    @Override
    public String toString(){
        return razonSocial;
    }
}
