package modelo;

public class ReferentesPro {
    private int codigo;
    private String nombre;
    private String email;
    private String telefono;

    public ReferentesPro(int codigo, String nombre, String email, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
