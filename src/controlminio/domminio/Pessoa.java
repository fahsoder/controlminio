package controlminio.domminio;

import controlminio.bdConnection.MysqlConnect;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class  Pessoa {
    private Long idUsuario;
    private String nome;
    private String cpf;
    private String rg;
    private String sexo;
    private Integer idade;
    private LocalDate dataNascimento;
    private Apartamento apartamento;

    public Pessoa(String nome, String cpf, String rg, String sexo, LocalDate dataNascimento) throws SQLException {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.idade = calculaIdade(dataNascimento);
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public String getSexo() {
        return this.sexo;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public Apartamento getApartamento() {
        return this.apartamento;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    private Integer calculaIdade(LocalDate dataNascimento) {
        LocalDate now = LocalDate.now();
        Period diff = Period.between(dataNascimento, now);
        Integer idade = diff.getYears();

        return idade;
    }
}
