package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa um voluntário, com seus dados básicos, curso inscrito e se aprovado em avalição do curso, um certificado.
 * @version 1.0
 */
public class Voluntario {
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String ocupacao;
    private String habilidade;
    private CursoBasico cursoBasico;
    private CursoAvancado cursoAvancado;
    private Certificado certificadoCursoBasico;
    private Certificado certificadoCursoAvancado;

    public Voluntario() {
    }

    public Voluntario(String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone, String ocupacao, String habilidade) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.ocupacao = ocupacao;
        this.habilidade = habilidade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public CursoBasico getCursoBasico() {
        return cursoBasico;
    }

    public void setCursoBasico(CursoBasico cursoBasico) {
        this.cursoBasico = cursoBasico;
    }

    public CursoAvancado getCursoAvancado() {
        return cursoAvancado;
    }

    public void setCursoAvancado(CursoAvancado cursoAvancado) {
        this.cursoAvancado = cursoAvancado;
    }

    public Certificado getCertificadoCursoBasico() {
        return certificadoCursoBasico;
    }

    public void setCertificadoCursoBasico(Certificado certificadoCursoBasico) {
        this.certificadoCursoBasico = certificadoCursoBasico;
    }

    public Certificado getCertificadoCursoAvancado() {
        return certificadoCursoAvancado;
    }

    public void setCertificadoCursoAvancado(Certificado certificadoCursoAvancado) {
        this.certificadoCursoAvancado = certificadoCursoAvancado;
    }
}
