package br.com.fiap.bean;

import java.time.LocalDate;

/**
 * Classe responsável pela modelagem do certificado do voluntário
 * @version 1.0
 */
public class Certificado {
    private Curso curso;
    private Voluntario voluntario;
    private LocalDate dataEmissao;

    public Certificado() {
    }

    public Certificado(Curso curso, Voluntario voluntario) {
        this.curso = curso;
        this.voluntario = voluntario;
        this.dataEmissao = LocalDate.now();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao  = dataEmissao;
    }

}
