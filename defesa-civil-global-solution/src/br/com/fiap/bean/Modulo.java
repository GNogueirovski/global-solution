package br.com.fiap.bean;

/**
 * Classe que representa um módulo, que é o conteúdo a ser ministrado no curso.
 * @version 1.0
 */
public class Modulo {
    private String nome;
    private String videoUrl;
    private String conteudoTextual;

    public Modulo() {
    }

    public Modulo(String nome, String videoUrl, String conteudoTextual) {
        this.nome = nome;
        this.videoUrl = videoUrl;
        this.conteudoTextual = conteudoTextual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getConteudoTextual() {
        return conteudoTextual;
    }

    public void setConteudoTextual(String conteudoTextual) {
        this.conteudoTextual = conteudoTextual;
    }
}
