package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Voluntario extends Pessoa {
    private String habilidade;
    private Curso curso;
    private Certificado certificado;
    private boolean aprovadoEmAvaliacao;

    public Voluntario() {
    }

    public Voluntario(String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone, String ocupacao, String municipio, String habilidade) {
        super(nomeCompleto, cpf, dataNascimento, email, telefone, ocupacao, municipio);
        this.habilidade = habilidade;
        this.curso = null;
        this.certificado = null;
        this.aprovadoEmAvaliacao = false;
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

    // todo
    public void visualizarDadosBasicos() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        super.visualizarDadosBasicos();
        System.out.printf("Habilidade: %s\n", this.habilidade);
        if (this.curso != null) {
        if (aprovadoEmAvaliacao) {
            System.out.printf("Curso concluído: %s\n", this.curso.getNome());
            System.out.printf("Certificado emitido em: %s", certificado.getDataEmissao().format(dtf));
        }else {
            System.out.printf("Curso em progresso: %s\n", curso.getNome());
            System.out.println("Avaliação pendente do curso");
        }
        } else {
            System.out.println("Voluntário ainda não está associado a nenhum curso");
        }
    }

    public boolean realizaAvaliacaoCurso(String resposta) {
        if(curso != null && curso.getAvaliacao() != null){
           boolean passou = curso.getAvaliacao().verificarResposta(resposta);
           if(passou){
               System.out.printf("Parabéns, você foi aprovado na avaliação do curso %s", curso.getNome());
               aprovadoEmAvaliacao = true;
               return true;
           } else {
               System.out.printf("Infelizmente, você não foi aprovado na avaliação do curso %s", curso.getNome());
               aprovadoEmAvaliacao = false;
               return false;
           }
        } else {
            System.out.println("Não é possível a realizar a avaliação de um curso que não existe");
            aprovadoEmAvaliacao = false;
            return false;
        }
    }
}
