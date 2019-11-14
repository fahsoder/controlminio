package controlminio.domminio;

public class Edificio  {
    private int idEdificio;
    private Condominio condominio;
    private String cor;
    private int qntAndar;

    public Edificio() {
        this.idEdificio = idEdificio;
        this.condominio = condominio;
        this.cor = cor;
        this.qntAndar = qntAndar;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public int getQntAndar() {
        return qntAndar;
    }

    public String getCor() {
        return cor;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setQntAndar(int qntAndar) {
        this.qntAndar = qntAndar;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
