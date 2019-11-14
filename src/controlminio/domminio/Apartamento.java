package controlminio.domminio;

public abstract class Apartamento extends  Edificio {

    private int idApartamento;
    private Edificio edificio;
    private int andar;
    private Pessoa proprietario;


    public Apartamento(int idApartamento, Edificio edificio, int andar, Pessoa proprietario) {
        super(idEdificio,condominio, cor, qntdAndar);
        this.idApartamento = idApartamento;
        this.andar = andar;
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

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

}
