package br.com.fiap.bean;

/**
 * Classe que representa um município com dados básicos, inclusive de tipo de risco sucetivel e voluntario (de qualquer natureza)
 * @version 1.0
 */
public class Municipio {
    private String nome;
    private String estado;
    private String tipoRisco;
    private Voluntario voluntario;

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

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    /**
     * Metodo que faz o registro do voluntário de qualquer natureza, que se disponibilizaram para o município.
     */
    public void registrarVoluntario (Voluntario voluntario){
        try{
            if (voluntario != null) {
            if (this.voluntario == null) {
            this.voluntario = voluntario;
            } else{
                throw new Exception("O municipio atingiu o limite de voluntários");
            }
            }else{
            throw new Exception("É necessário um voluntário válido para efetuar o registro");
            }
        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
