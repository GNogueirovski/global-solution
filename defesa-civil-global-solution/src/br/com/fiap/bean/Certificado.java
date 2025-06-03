package br.com.fiap.bean;

import java.time.LocalDate;

public class Certificado {
    private Curso curso;
    private Voluntario voluntario;
    private LocalDate dataEmissao;

    public Certificado() {
    }

    public Certificado(Curso curso, Voluntario voluntario) {
        this.curso = curso;
        setVoluntario(voluntario);
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
        try{
            if (voluntario.isAprovadoEmAvaliacao()) {
                this.voluntario = voluntario;
            }else {
                throw new Exception("O voluntário precisa estar aprovado na Avaliação do curso, para receber um certificado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

}
