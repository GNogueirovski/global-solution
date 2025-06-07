package br.com.fiap.bean;

/**
 * Classe responsável pelo armazenamento do curso, contendo um módulo (conteúdo ministrado) e uma avaliação,
 * que será responsável por aprovar o voluntário no curso.
 * @version 1.0
 */
public class CursoBasico {
    private String nome;
    private String tipo;
    private String descricao;
    private Modulo modulo;
    private int cargaHoraria;

    public CursoBasico() {
    }

    public CursoBasico(String nome, String tipo, String descricao, Modulo modulo, int cargaHoraria) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.modulo = modulo;
        setCargaHoraria(cargaHoraria);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Modulo getModulo() {
        return modulo;
    }
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        try {
            if (cargaHoraria >= 20 && cargaHoraria <= 40) {
                this.cargaHoraria = cargaHoraria;
            } else {
                throw new Exception("Os cursos tem que ter a carga horária entre 20 até 40 horas");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //todo
    public boolean concluirCurso(Voluntario voluntario) {
        Certificado certificado;
        if (voluntario.getCertificadoCursoBasico() == null) {
            certificado = new Certificado(this.nome, voluntario);
            voluntario.setCertificadoCursoBasico(certificado);
            return true;
        }
        return false;
    }
}
