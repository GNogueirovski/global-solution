package br.com.fiap.main;

import br.com.fiap.bean.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao,menuInterno;
        String escolha = "sim";
        Scanner sc = new Scanner(System.in);
        Municipio portoAlegre;
        Voluntario voluntarioPortoAlegre;
        DefesaCivilMunicipal defesaPortoAlegre;
        Curso cursoBasico;
        Modulo moduloCursoBasico;
        Avaliacao avaliacaoCursoBasico;
        Certificado certificadoCursoBasico;

        // Criando novo município e a Defesa Civil do Município criado
        portoAlegre = new Municipio("Porto Alegre", "Rio Grande do Sul", "Risco de Enchente");
        defesaPortoAlegre = new DefesaCivilMunicipal("Defesa Civil de Porto Alegre", "Rio Grande do Sul", "Risco de Enchente", "Marcelo Teixeira");

        // Criando voluntário e adicionando ao voluntário de Porto Alegre (NÃO DA DEFESA CIVIL DE PORTO ALEGRE)
        voluntarioPortoAlegre = new Voluntario("Carlos Menezes", "987.654.321-00", LocalDate.of(1985, 8, 12), "carlos.m@email.com", "(51) 98888-7777", "Agente de Manutenção", "Experiência em Solda e Elétrica");
        portoAlegre.setVoluntario(voluntarioPortoAlegre);

        // Criando Curso Básico sem módulo a partir da Defesa Civil
        cursoBasico = defesaPortoAlegre.criarCurso("Curso Básico de Gestão de Crise em Enchentes", "Treinamento Obrigatório", "Aprenda noções essenciais de prevenção, resposta e recuperação em situações de enchentes, com foco em ação rápida, segurança e comunicação eficaz", 40);
        // Setando como curso principal da Defesa e como curso matriculado do voluntário
        defesaPortoAlegre.setCursoPrincipal(cursoBasico);
        voluntarioPortoAlegre.setCurso(cursoBasico);

        // Criando a avaliação do curso básico
        avaliacaoCursoBasico = defesaPortoAlegre.criarAvaliacao(cursoBasico, "Qual é a primeira atitude recomendada para um voluntário ao chegar a uma área afetada por enchente?","A) Entrar na água para resgatar vítimas", "B) Aguardar orientação das autoridades locais", "C) Distribuir alimentos por conta própria", "D) Registrar a situação nas redes sociais", "b");


        while (escolha.equalsIgnoreCase("sim")) {
            try{

                System.out.print("Bem-vindo ao Sistema de Voluntários da Defesa Civil \nEscolha o menu para acessar correspondente ao seu perfil: \n1) Menu da Defesa Civil \n2) Menu do Voluntário\n\n");
                System.out.print("Escolha:");
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.printf("Olá Agente %s, seja Bem-vindo!\nCurso Gerenciado: %s\n\nSelecione a opção desejada no menu:\n1) Adicionar módulo ao curso\n2) Emitir o certificado para o voluntário\n3) Registrar voluntário como apto\n\n", defesaPortoAlegre.getNomeAgenteResponsavel(),defesaPortoAlegre.getCursoPrincipal().getNome());
                        System.out.print("Escolha:");
                        menuInterno = sc.nextInt();
                        sc.nextLine();
                        switch (menuInterno){
                            case 1:
                                moduloCursoBasico = new Modulo();
                                System.out.printf("Curso a ser gerenciado: %s\n", defesaPortoAlegre.getCursoPrincipal().getNome());
                                System.out.println("Insira o nome do módulo que será ministrado: ");
                                moduloCursoBasico.setNome(sc.nextLine());

                                System.out.println("Insira a URL do vídeo do módulo que será ministrado: ");
                                moduloCursoBasico.setVideoUrl(sc.nextLine());

                                System.out.println("Insira o conteúdo textual que será utilizado: ");
                                moduloCursoBasico.setConteudoTextual(sc.nextLine());

                                cursoBasico.adicionarModulo(moduloCursoBasico);
                                System.out.printf("\nMódulo %s criado com sucesso!", moduloCursoBasico.getNome());

                                break;
                            case 2:
                                defesaPortoAlegre.emitirCertificado(cursoBasico, voluntarioPortoAlegre);
                                break;
                            case 3:
                                defesaPortoAlegre.registrarVoluntario(voluntarioPortoAlegre);
                                break;
                            default:
                                System.out.println("Escolha Inválida, tente novamente");
                                break;
                        }
                        break;
                    case 2:
                        System.out.printf("Olá voluntário %s, seja Bem-vindo!\nSeu curso: %s\n\nSelecione a opção desejada no menu:\n1) Realizar a Avaliação do Curso\n2) Visualizar Certificado\n\n", voluntarioPortoAlegre.getNomeCompleto(),voluntarioPortoAlegre.getCurso().getNome());
                        System.out.print("Escolha:");
                        menuInterno = sc.nextInt();
                        sc.nextLine();
                        switch (menuInterno) {
                            case 1:
                                if (cursoBasico.getModulo() != null) {
                                System.out.printf("Seja Bem-vindo a avaliação do %s\n\n", cursoBasico.getNome());
                                System.out.printf("Pergunta: %s\n",cursoBasico.getAvaliacao().getPergunta());
                                System.out.println("Alternativas: ");
                                System.out.println(cursoBasico.getAvaliacao().getAlternativaA());
                                System.out.println(cursoBasico.getAvaliacao().getAlternativaB());
                                System.out.println(cursoBasico.getAvaliacao().getAlternativaC());
                                System.out.println(cursoBasico.getAvaliacao().getAlternativaD());
                                System.out.println("Selecione a alternativa (apenas letra): ");

                                voluntarioPortoAlegre.realizaAvaliacaoCurso(sc.nextLine());
                                } else{
                                    throw new Exception("Não é possível fazer a avaliação de um curso sem módulo atribuído\n");
                                }
                                break;
                            case 2:
                                voluntarioPortoAlegre.visualizarCertificado();
                                break;
                            default:
                                System.out.println("Escolha Inválida, tente novamente");
                                break;
                        }
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        escolha = "nao";
                        break;
                    default:
                        System.out.println("Escolha Inválida, tente novamente");
                        break;
                }

                System.out.println("Deseja continuar? (sim/nao)");
                escolha = sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Obrigado por utilizar o programa!");


    }
}
