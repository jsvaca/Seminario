package Entidades;

public class ComplejoIndustrial {
    private int codigoCI;
    private String denominacion;
    private String ubicacion;
    private String razonSocial;
    private ReferenteCI referente;

    public ComplejoIndustrial(int codigoCI, String denominacion, String ubicacion, String razonSocial,
                              ReferenteCI referente) {
        this.codigoCI = codigoCI;
        this.denominacion = denominacion;
        this.ubicacion = ubicacion;
        this.razonSocial = razonSocial;
        this.referente = referente;
    }

    public ComplejoIndustrial() {
        this.codigoCI = 0;
        this.denominacion = "";
        this.ubicacion = "";
        this.razonSocial = "";
        this.referente = null;
    }

    public ReferenteCI getReferente() {
        return referente;
    }

    public void setReferente(ReferenteCI referente) {
        this.referente = referente;
    }

    public int getCodigoCI() {
        return codigoCI;
    }

    public void setCodigoCI(int codigoCI) {
        this.codigoCI = codigoCI;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
