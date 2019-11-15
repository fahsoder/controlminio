package controlminio.domminio;

public abstract class Apartamento {

    private int idApartamento;
    private Edificio edificio;
    private int andar;
    private Pessoa proprietario;

    public Apartamento(int idApartamento, Edificio edificio, int andar, Pessoa proprietario) {
        this.idApartamento = idApartamento;
        this.edificio = edificio;
        this.andar = andar;
        this.proprietario = proprietario;
    }

    public void criarID(int idApartamento) {
        this.idApartamento += 1;
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

    public int getIdApartamento() {
        return idApartamento;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public int getAndar() {
        return andar;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }
}
