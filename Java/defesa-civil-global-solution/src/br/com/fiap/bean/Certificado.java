package br.com.fiap.bean;

import java.time.LocalDate;

/**
 * Classe responsável pela modelagem do certificado do voluntário
 * @version 1.0
 */
public class Certificado {
    private String nomeCurso;
    private Voluntario voluntario;
    private LocalDate dataEmissao;

    public Certificado() {
    }

    public Certificado(String nomeCurso, Voluntario voluntario) {
        this.nomeCurso = nomeCurso;
        this.voluntario = voluntario;
        this.dataEmissao = LocalDate.now();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
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
        this.dataEmissao = dataEmissao;
    }
}
