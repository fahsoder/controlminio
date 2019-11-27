package controlminio.domminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.SQLException;

public class ApartamentoPadrao extends Apartamento {
    private String tipoPiso;
    private String tipoArmario;

    public ApartamentoPadrao(Edificio edificio, int andar, Integer numero, String tipoPiso, String tipoArmario) throws SQLException {
        super(edificio, andar, numero, TipoApartamento.PADRAO);
        this.tipoArmario = tipoArmario;
        this.tipoPiso = tipoPiso;
    }

    public String getTipoArmario() {
        return this.tipoArmario;
    }

    public void setTipoArmario(String tipoArmario) {
        this.tipoArmario = tipoArmario;
    }

    public String getTipoPiso() {
        return this.tipoPiso;
    }

    public void setTipoPiso(String tipoPiso) {
        this.tipoPiso = tipoPiso;
    }

}
