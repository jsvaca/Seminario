package Entidades;

public class ReferenteCI extends Referente{

    private int interno;

    public ReferenteCI(int codigo, String nombre, String email, String telefono, int interno) {
        super(codigo, nombre, email, telefono);
        this.interno = interno;
    }

    public int getInterno() {
        return interno;
    }

    public void setInterno(int interno) {
        this.interno = interno;
    }


}
