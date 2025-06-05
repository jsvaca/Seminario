package Entidades;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Nominacion {
    private ComplejoIndustrial ci;
    private int numeroOrden;
    private LocalDate fecha;

    public Nominacion(ComplejoIndustrial ci, int numeroOrden, LocalDate fecha) {
        this.ci = ci;
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
    }

    public ComplejoIndustrial getCi() {
        return ci;
    }

    public void setCi(ComplejoIndustrial ci) {
        this.ci = ci;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //este metodo no va en esta clase
    boolean validarFecha (String fechaCargada){
        boolean valida = false;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        LocalDate fecha = LocalDate.parse(fechaCargada, formato);

        if (fecha.isAfter(fechaActual)){
            valida = true;
        }
        return valida;
    }
}
