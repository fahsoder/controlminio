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

    public void setIdEdificio(Long idEdificio) {
        this.idEdificio = idEdificio;
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
}
