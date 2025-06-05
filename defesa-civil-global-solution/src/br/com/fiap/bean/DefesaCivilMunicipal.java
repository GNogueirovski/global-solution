package br.com.fiap.bean;

import java.time.format.DateTimeFormatter;

/**
 * Classe que representa a Defesa Civil Municipal e filha de Município.
 * É responsável pela criação de curso, avaliação, emissão de certificado e
 * registro de voluntários aptos para emergências.
 * @version 1.0
 */
public class DefesaCivilMunicipal extends Municipio {
    private String nomeAgenteResponsavel;
    private Curso cursoPrincipal;

    public DefesaCivilMunicipal() {
    }

    public DefesaCivilMunicipal(String nome, String estado, String tipoRisco, String nomeAgenteResponsavel) {
        super(nome, estado, tipoRisco);
        this.nomeAgenteResponsavel = nomeAgenteResponsavel;
    }

    public String getNomeAgenteResponsavel() {
        return nomeAgenteResponsavel;
    }

    public void setNomeAgenteResponsavel(String nomeAgenteResponsavel) {
        this.nomeAgenteResponsavel = nomeAgenteResponsavel;
    }

    public Curso getCursoPrincipal() {
        return cursoPrincipal;
    }

    public void setCursoPrincipal(Curso cursoPrincipal) {
        this.cursoPrincipal = cursoPrincipal;
    }


    /**
     * Metodo que faz o registro do voluntário apto, que fizeram o curso e a avaliação
     * e atribui a Defesa Civil Municipal.
     */
    @Override
    public void registrarVoluntario(Voluntario voluntario) {
        try{
            if (voluntario != null) {
                if (getVoluntario() == null) {
                    if (voluntario.isAprovadoEmAvaliacao()){
                    setVoluntario(voluntario);
                    System.out.printf("Voluntário Apto registrado com sucesso!\nNome: %s \nCertificado em %s!\n", voluntario.getNomeCompleto(), voluntario.getCurso().getNome());
                    }
                    else{
                        throw new Exception("O voluntário não está apto para prestar serviços para a Defesa Civil");
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
    public Curso criarCurso(String nomeCurso, String tipo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setNome(nomeCurso);
        curso.setTipo(tipo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    /**
     * Metodo que cria um curso completo que ainda está pendente de uma avaliação.
     * @return faz o retorno de um curso para ser atribuído à Defesa Civil
     */
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

    /**
     * Metodo que cria uma avaliação para um curso, com a pergunta, as respectivas alternativas e qual é a correta.
     * @return Retorna uma avaliação que será atribuida a um curso da Defesa Civil
     */
    public Avaliacao criarAvaliacao(Curso curso, String pergunta, String altA, String altB, String altC, String altD, String altCorreta) {
        try{
            if (curso != null) {
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setPergunta(pergunta);
            avaliacao.setAlternativaA(altA);
            avaliacao.setAlternativaB(altB);
            avaliacao.setAlternativaC(altC);
            avaliacao.setAlternativaD(altD);
            avaliacao.setAlternativaCorreta(altCorreta.toLowerCase());

            curso.setAvaliacao(avaliacao);

            return avaliacao;

        } else {
            throw new Exception("Não é possivel criar uma avaliacão para um curso nulo");
        }} catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * Metodo que emite de um certificado de um voluntário que foi aprovado na avaliação de um curso
     */
    public void emitirCertificado(Curso curso, Voluntario voluntario) {
        Certificado certificado;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            if (curso != null) {
                if (voluntario.isAprovadoEmAvaliacao() && voluntario.getCurso().equals(curso)) {
                    certificado = new Certificado(curso, voluntario);
                    voluntario.setCertificado(certificado);
                    System.out.printf("Certificado em %s emitido com sucesso!\nNome do Voluntário %s\nData de Emissão: %s\n",curso.getNome(), voluntario.getNomeCompleto(), certificado.getDataEmissao().format(dtf));
            } else {
                    throw new Exception("O voluntário deve ter sido aprovado na avaliação para receber o certificado");
                }
            }else {
                throw new Exception("Não é possivel emitir o certificado para um curso vazio");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
