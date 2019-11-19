package controlminio.domminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.SQLException;

public class ApartamentoLuxo extends Apartamento {
    private String luminarias;
    private boolean geladeira;
    private boolean fogao;

    public ApartamentoLuxo(Edificio edificio, Integer andar, Pessoa proprietario, String luminarias, Integer numero, boolean geladeira, boolean fogao) throws SQLException {
        super(edificio, andar, numero, TipoApartamento.LUXO );
        this.luminarias = luminarias;
        this.geladeira = geladeira;
        this.fogao = fogao;

        save();
    }

    public String getLuminarias() {
        return this.luminarias;
    }

    public void setLuminarias() {
        this.luminarias = luminarias;
    }

    public boolean isGeladeira() {
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

    private void save() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        conn.insert("INSERT INTO ApartamentoLuxo (idApartamento, luminaria, geladeira, fogao)" +
                "VALUES ('" + super.getIdApartamento() + "', '" + this.luminarias + "', '" + this.geladeira + "', '" + this.fogao + "')");
    }

}
