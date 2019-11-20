package controlminio.domminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.SQLException;

public class Condominio {
    private Long idCondominio;
    private String nome;
    private String cidade;
    private String bairro;
    private String endereco;
    private Integer numero;

    public Condominio(String nome, String cidade, String bairro, String endereco, Integer numero) throws SQLException {
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;

        save();
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public Long getIdCondominio() {
        return this.idCondominio;
    }

    public String getNome() {
        return this.nome;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    private void save() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        this.idCondominio = (Long) (long) conn.insert("INSERT INTO Condominio (endereco, nome, cidade, bairro, numero) " +
                "VALUES ('" + this.endereco + "', '" + this.nome + "', '" + this.cidade + "', '" + this.bairro + "', '" + this.numero + "')");
    }

}
