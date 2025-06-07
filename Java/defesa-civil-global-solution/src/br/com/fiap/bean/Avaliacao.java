package br.com.fiap.bean;

/**
 * Classe responsável pela criação de uma avaliação, que servirá para realizar a pergunta, exibir as alternativas
 * e validar se o usuário acertou
 * @version 1.0
 */
public class Avaliacao {
    private String pergunta;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaCorreta;
    private boolean acertou;

    public Avaliacao() {
    }

    public Avaliacao(String pergunta, String alternativaA, String alternativaB, String alternativaC, String alternativaD, String alternativaCorreta) {
        this.pergunta = pergunta;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        try{
            if (alternativaCorreta.equalsIgnoreCase("A") || alternativaCorreta.equalsIgnoreCase("B")|| alternativaCorreta.equalsIgnoreCase("C")|| alternativaCorreta.equalsIgnoreCase("D")){
                this.alternativaCorreta = alternativaCorreta;
            }else {
                throw new Exception("Insira apenas a letra da alternativa correta");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isAcertou() {
        return acertou;
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }

    /**
     * Metodo que verifica a resposta do usuário e muda o estado de acertouPergunta para true
     */
    public void verificarResposta(String resposta) {
        if (resposta.equalsIgnoreCase(getAlternativaCorreta())){
            setAcertou(true);
        }
       }
    }


