package br.com.fiap.bean;

public class CursoAvancado extends CursoBasico{
    private Avaliacao avaliacao;

    public CursoAvancado() {}

    public CursoAvancado(String nome, String tipo, String descricao, Modulo modulo, int cargaHoraria, Avaliacao avaliacao) {
        super(nome, tipo, descricao, modulo, cargaHoraria);
        this.avaliacao = avaliacao;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean concluirCurso(Voluntario voluntario) {
        Certificado certificado;
        if (voluntario.getCertificadoCursoAvancado() == null) {
            if (avaliacao.isAcertou()){
               certificado = new Certificado(this.getNome(), voluntario);
               voluntario.setCertificadoCursoAvancado(certificado);
               return true ;
            }
        }
        return false;
    }

}
