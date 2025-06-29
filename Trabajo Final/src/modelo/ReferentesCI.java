package modelo;

public class ReferentesCI {
    private int codigo;
    private String nombre;
    private String email;
    private int interno;
    private String celular;

    public ReferentesCI(int codigo, String nombre, String email, int interno, String celular) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.interno = interno;
        this.celular = celular;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getInterno() {
        return interno;
    }

    public String getCelular() {
        return celular;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
