package br.com.fiap.bean;

/**
 * Classe que representa um município com dados básicos, inclusive de tipo de risco sucetivel e voluntario (de qualquer natureza)
 * @version 1.0
 */
public class Municipio {
    private String nome;
    private String estado;
    private String tipoRisco;

    public Municipio() {
    }

    public Municipio(String nome, String estado, String tipoRisco) {
        this.nome = nome;
        this.estado = estado;
        this.tipoRisco = tipoRisco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoRisco() {
        return tipoRisco;
    }

    public void setTipoRisco(String tipoRisco) {
        this.tipoRisco = tipoRisco;
    }
}
