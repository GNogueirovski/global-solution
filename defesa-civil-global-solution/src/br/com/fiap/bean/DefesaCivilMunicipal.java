package br.com.fiap.bean;

import java.time.LocalDate;

public class DefesaCivilMunicipal {
    private String nomeMunicipio;
    private Pessoa agenteResponsavel;
    private Curso cursoPrincipal;

    public DefesaCivilMunicipal() {
    }

    public DefesaCivilMunicipal(String nomeMunicipio, Pessoa agenteResponsavel) {
        this.nomeMunicipio = nomeMunicipio;
        this.agenteResponsavel = agenteResponsavel;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Pessoa getAgenteResponsavel() {
        return agenteResponsavel;
    }

    public void setAgenteResponsavel(Pessoa agenteResponsavel) {
        this.agenteResponsavel = agenteResponsavel;
    }

    public Curso getCursoPrincipal() {
        return cursoPrincipal;
    }

    public void setCursoPrincipal(Curso cursoPrincipal) {
        this.cursoPrincipal = cursoPrincipal;
    }

    public Curso criarCurso(String nomeCurso, String tipo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setNome(nomeCurso);
        curso.setTipo(tipo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    public Curso criarCurso(String nomeCurso, String tipo,String nomeModulo,String videoUrl, String conteudoTextual, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        Modulo modulo = new Modulo(nomeModulo,videoUrl,conteudoTextual);

        curso.setNome(nomeCurso);
        curso.setTipo(tipo);
        curso.setModulo(modulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    public void criarAvaliacao(Curso curso, String pergunta, String altA, String altB, String altC, String altD, String altCorreta) {
        try{
            if (curso != null) {
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setPergunta(pergunta);
            avaliacao.setAlternativaA(altA.toLowerCase());
            avaliacao.setAlternativaB(altB.toLowerCase());
            avaliacao.setAlternativaC(altC.toLowerCase());
            avaliacao.setAlternativaD(altD.toLowerCase());
            avaliacao.setAlternativaCorreta(altCorreta.toLowerCase());

            curso.setAvaliacao(avaliacao);

            System.out.printf("Avaliação criada com sucesso para o curso %s",curso.getNome());
        } else {
            throw new Exception("Não é possivel criar uma avaliacão para um curso vazio");
        }} catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void emitirCertificado(Curso curso, Voluntario voluntario) {
        Certificado certificado;
        try{
            if (curso != null) {
                if (voluntario.isAprovadoEmAvaliacao() && voluntario.getCurso().equals(curso)) {
                    certificado = new Certificado(curso, voluntario);
                    voluntario.setCertificado(certificado);
            } else {
                    throw new Exception("O voluntário deve ter sido aprovado na avaliação para receber o certificado");
                }
            }else {
                throw new Exception("Não é possivel criar uma avaliacão para um curso vazio");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
