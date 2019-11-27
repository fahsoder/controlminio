package controlminio.domminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.SQLException;

public class ApartamentoLuxo extends Apartamento {
    private String luminarias;
    private boolean geladeira;
    private boolean fogao;

    public ApartamentoLuxo(Edificio edificio, Integer andar, String luminarias, Integer numero, boolean geladeira, boolean fogao) throws SQLException {
        super(edificio, andar, numero, TipoApartamento.LUXO );
        this.luminarias = luminarias;
        this.geladeira = geladeira;
        this.fogao = fogao;
    }

    public String getLuminarias() {
        return this.luminarias;
    }

    public void setLuminarias() {
        this.luminarias = luminarias;
    }

    public boolean getGeladeira() {
        return this.geladeira;
    }

    public void setGeladeira(boolean geladeira) {
        this.geladeira = geladeira;
    }

     public boolean getFogao(){
        return this.fogao;
     }

     public void setFogao( boolean fogao){
        this.fogao = fogao;
     }

}
