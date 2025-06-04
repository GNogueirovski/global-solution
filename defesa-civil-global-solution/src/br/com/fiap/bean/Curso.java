package br.com.fiap.bean;

public class Curso {
    private String nome;
    private String tipo;
    private String descricao;
    private Modulo modulo;
    private int cargaHoraria;
    private Avaliacao avaliacao;

    public Curso() {
    }
    public Curso(String nome, String tipo, String descricao, int cargaHoraria) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        setCargaHoraria(cargaHoraria);
    }


    public Curso(String nome, String tipo, String descricao, Modulo modulo, int cargaHoraria) {
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

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void adicionarModulo(Modulo modulo) {
        try {
            if(this.modulo == null){
                this.modulo = modulo;
            } else {
                throw new Exception("O curso já tem um módulo");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
