package controlminio.domminio;

import java.util.Date;

public class  Pessoa {
    private Long idUsuario;
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private Integer idade;
    private Date dataNascimento;
    private Apartamento propietario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Apartamento getPropietario() {
        return propietario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario += 1;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setPropietario(Apartamento propietario) {
        this.propietario = propietario;
    }
}
