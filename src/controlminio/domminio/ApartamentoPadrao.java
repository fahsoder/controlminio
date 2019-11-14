package controlminio.domminio;

public class ApartamentoPadrao extends Apartamento {
    private String tipoApartamento;
    private String tipoPiso;

    public ApartamentoPadrao() {
        super(idApartamento);
    }

    public String getTipoApartamento() {
        return tipoApartamento;
    }

    public void setTipoApartamento(String tipoApartamento) {
        this.tipoApartamento = tipoApartamento;
    }

    public String getTipoPiso() {
        return tipoPiso;
    }

    public void setTipoPiso(String tipoPiso) {
        this.tipoPiso = tipoPiso;
    }

}
