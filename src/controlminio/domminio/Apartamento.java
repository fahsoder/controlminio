package controlminio.domminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.SQLException;

public abstract class Apartamento {

    private Long idApartamento;
    private Edificio edificio;
    private Integer andar;
    private Pessoa proprietario;
    private Integer numero;
    private TipoApartamento tipoApartamento;


    public Apartamento(Edificio edificio, Integer andar, Integer numero, TipoApartamento tipoApartamento) throws SQLException {
        this.edificio = edificio;
        this.andar = andar;
        this.numero = numero;
        this.tipoApartamento = tipoApartamento;

        save();
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public void setProprietario(Pessoa proprietario) throws SQLException {
        this.proprietario = proprietario;
        saveProprietario();
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTipoApartamento(TipoApartamento tipoApartamento) {
        this.tipoApartamento = tipoApartamento;
    }

    public Long getIdApartamento() {
        return this.idApartamento;
    }

    public Edificio getEdificio() {
        return this.edificio;
    }

    public Integer getAndar() {
        return this.andar;
    }

    public Pessoa getProprietario() {
        return this.proprietario;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public TipoApartamento getTipoApartamento() {
        return this.tipoApartamento;
    }

    private void save() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        this.idApartamento = (Long) (long) conn.insert("INSERT INTO Apartamento (idEdificio, andar, numero, tipo) " +
                "VALUES ('" + this.getEdificio().getIdEdificio() + "', '" + this.getAndar() + "', '" + this.getNumero() +
                "', '" + this.tipoApartamento.name() + "')");
    }

    private void saveProprietario() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        conn.insert("UPDATE Apartamento SET idProprietario = " + this.proprietario.getIdUsuario());
    }

}
