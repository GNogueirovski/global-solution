package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Voluntario {
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String ocupacao;
    private String habilidade;
    private Curso curso;
    private Certificado certificado;
    private boolean aprovadoEmAvaliacao;

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public boolean isAprovadoEmAvaliacao() {
        return aprovadoEmAvaliacao;
    }

    public void setAprovadoEmAvaliacao(boolean aprovadoEmAvaliacao) {
        this.aprovadoEmAvaliacao = aprovadoEmAvaliacao;
    }

    public void realizaAvaliacaoCurso(String resposta) {
        if(curso != null && curso.getAvaliacao() != null){
           boolean passou = curso.getAvaliacao().verificarResposta(resposta);
           if(passou){
               System.out.printf("Parabéns, você foi aprovado na avaliação do %s\nSeu certificado será disponibilizado quando a Defesa Civil fizer a emissão\n", curso.getNome());
               aprovadoEmAvaliacao = true;
           } else {
               System.out.printf("Infelizmente, você não foi aprovado na avaliação do %s\n Revise o conteúdo e tente novamente!\n", curso.getNome());
               aprovadoEmAvaliacao = false;
           }
        } else {
            System.out.println("Não é possível a realizar a avaliação de um curso que o voluntário não está registrado\n");
            aprovadoEmAvaliacao = false;
        }
    }

    public void visualizarCertificado (){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            if (aprovadoEmAvaliacao) {
                if(certificado != null){
                    System.out.printf("Curso: %s\n", curso.getNome());
                    System.out.printf("Voluntário: %s\n", getNomeCompleto());
                    System.out.printf("Emitido em: %s\n", certificado.getDataEmissao().format(dtf));
                }else {
                    throw new Exception("O certificado ainda precisa ser emitido pela Defesa Civil para ser visualizado");
                }
            } else {
                throw new Exception("O voluntário ainda precisa passar pela avaliação do curso para receber o certificado.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
