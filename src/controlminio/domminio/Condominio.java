package controlminio.domminio;
// Criar metodo para Ids infinitos;
public class Condominio {
    private int idCondominio;
    private String nome;
    private String cidade;
    private String bairro;
    private String endereco;

    public Condominio(int idCondominio, String nome, String cidade, String bairro, String endereco) {
        this.idCondominio = idCondominio;
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this. endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public int getIdCondominio() {
        return idCondominio;
    }

    public String getNome() {
        return nome;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
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
}
