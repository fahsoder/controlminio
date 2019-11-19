package controlminio.domminio;

import java.util.Random;


public abstract class Apartamento {

    private Long idApartamento;
    private Edificio edificio;
    private Integer andar;
    private Pessoa proprietario;

    Utilitarios utilitarios;

    public Apartamento(Edificio edificio, Integer andar, Pessoa proprietario) {
        this.idApartamento = utilitarios.criarId();
        this.edificio = edificio;
        this.andar = andar;
        this.proprietario = proprietario;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public Long getIdApartamento() {
        return idApartamento;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public Integer getAndar() {
        return andar;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }
}
