package controlminio.domminio;

public class Edificio  {
    private Long idEdificio;
    private Condominio condominio;
    private String cor;
    private Integer qntAndar;

    Utilitarios utilitarios;

    public Edificio(Condominio condominio, String cor, Integer qntAndar) {
        this.idEdificio = utilitarios.criarId();
        this.condominio = condominio;
        this.cor = cor;
        this.qntAndar = qntAndar;
    }

    public Long getIdEdificio() {
        return idEdificio;
    }

    public Integer getQntAndar() {
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
