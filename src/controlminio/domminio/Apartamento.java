package controlminio.domminio;

import java.util.Random;


public abstract class Apartamento {

    private Long idApartamento;
    private Edificio edificio;
    private int andar;
    private Pessoa proprietario;

    public Apartamento(Edificio edificio, int andar, Pessoa proprietario) {
        this.idApartamento = this.criarId();
        this.edificio = edificio;
        this.andar = andar;
        this.proprietario = proprietario;
    }

    private Long criarId() {
        Random rand = new Random();
        return rand.nextLong();
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void setAndar(int andar) {
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
