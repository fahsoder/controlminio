package controlminio.domminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.SQLException;

public class Edificio  {
    private Long idEdificio;
    private Integer numero;
    private Condominio condominio;
    private String cor;
    private Integer qntAndar;

    public Edificio(Condominio condominio, Integer numero, String cor, Integer qntAndar) throws SQLException {
        this.condominio = condominio;
        this.numero = numero;
        this.cor = cor;
        this.qntAndar = qntAndar;

        save();
    }

    public Long getIdEdificio() {
        return this.idEdificio;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public Integer getQntAndar() {
        return this.qntAndar;
    }

    public String getCor() {
        return this.cor;
    }

    public Condominio getCondominio() {
        return this.condominio;
    }

    public void setQntAndar(Integer qntAndar) {
        this.qntAndar = qntAndar;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    private void save() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        this.idEdificio = (Long) (long) conn.insert("INSERT INTO Edificio (numero, cor, quantidadeAndar, idCondominio) " +
                "VALUES ('" + this.numero + "', '" + this.cor + "', '" + this.qntAndar +  "', '" + this.condominio.getIdCondominio() + "')");
    }
}
