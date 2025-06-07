package br.com.fiap.bean;

import java.time.format.DateTimeFormatter;

/**
 * Classe que representa a Defesa Civil Municipal e filha de Município.
 * É responsável pela criação de curso, avaliação, emissão de certificado e
 * registro de voluntários aptos para emergências.
 * @version 1.0
 */
public class DefesaCivilMunicipal {
    private Municipio municipio;
    private String nomeAgenteResponsavel;
    private Voluntario voluntario;
    private CursoBasico cursoBasico;
    private CursoAvancado cursoAvancado;


    public DefesaCivilMunicipal() {
    }

    public DefesaCivilMunicipal(Municipio municipio, String nomeAgenteResponsavel) {
        this.municipio = municipio;
        this.nomeAgenteResponsavel = nomeAgenteResponsavel;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getNomeAgenteResponsavel() {
        return nomeAgenteResponsavel;
    }

    public void setNomeAgenteResponsavel(String nomeAgenteResponsavel) {
        this.nomeAgenteResponsavel = nomeAgenteResponsavel;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
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

    /**
     * Metodo que faz o registro do voluntário apto, que fizeram o curso e a avaliação
     * e atribui a Defesa Civil Municipal.
     */
    public void registrarVoluntario(Voluntario voluntario) {
        try{
            if (voluntario != null) {
                if (getVoluntario() == null) {
                    if (voluntario.getCertificadoCursoBasico() != null && voluntario.getCertificadoCursoAvancado() != null){
                    setVoluntario(voluntario);
                    System.out.println("Voluntário Apto registrado com sucesso!");
                    }
                    else{
                        throw new Exception("O voluntário precisa concluir o curso básico e avançado para poder ser registrado na Defesa Civil");
                    }
                } else{
                    throw new Exception("O municipio atingiu o limite de voluntários");
                }
            }else{
                throw new Exception("É necessário um voluntário válido para efetuar o registro");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que cria um curso no seu estado mais básico, ainda precisando adicionar módulo e avaliação.
     * @return faz o retorno de um curso para ser atribuído à Defesa Civil
     */
    public CursoBasico criarCurso(String nomeCurso, String tipo, String descricao, int cargaHoraria, Modulo modulo) {
        CursoBasico curso = new CursoBasico();
        curso.setNome(nomeCurso);
        curso.setTipo(tipo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        curso.setModulo(modulo);
        return curso;
    }

    /**
     * Metodo que cria um curso no seu estado mais básico, ainda precisando adicionar módulo e avaliação.
     * @return faz o retorno de um curso para ser atribuído à Defesa Civil
     */
    public CursoAvancado criarCurso(String nomeCurso, String tipo, String descricao, int cargaHoraria, Modulo modulo, Avaliacao avaliacao) {
        CursoAvancado curso = new CursoAvancado();
        curso.setNome(nomeCurso);
        curso.setTipo(tipo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        curso.setModulo(modulo);
        curso.setAvaliacao(avaliacao);
        return curso;
    }


}
