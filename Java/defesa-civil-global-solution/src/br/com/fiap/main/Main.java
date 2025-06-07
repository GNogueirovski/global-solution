package br.com.fiap.main;

import br.com.fiap.bean.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao,menuInterno,cargaHorariaCursoAvancado;
        String escolha = "sim", nomeCursoAvancado, tipoCursoAvancado, descricaoCursoAvancado, dadosVoluntario;
        Scanner sc = new Scanner(System.in);
        Municipio portoAlegre;
        Voluntario voluntarioPortoAlegre;
        DefesaCivilMunicipal defesaPortoAlegre;
        CursoBasico cursoBasico;
        CursoAvancado cursoAvancado;
        Modulo moduloCursoBasico, moduloCursoAvancado;
        Avaliacao avaliacaoCursoAvancado;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formataData;

        // Criando novo município e a Defesa Civil do Município criado
        portoAlegre = new Municipio("Porto Alegre", "Rio Grande do Sul", "Risco de Enchente");
        defesaPortoAlegre = new DefesaCivilMunicipal(portoAlegre, "Marcelo Teixeira");

        // Cria um voluntário vazio
        voluntarioPortoAlegre = new Voluntario();

        //Criando módulo curso básico
        moduloCursoBasico = new Modulo("Primeiros passos na gestão de crises","link.com", "Este módulo introdutório apresenta os primeiros conceitos de gestão de crises\nVocê aprenderá a identificar uma crise, entender seus impactos e agir rapidamente.");
        // Criando Curso Básico
        cursoBasico = defesaPortoAlegre.criarCurso("Introdução a Gestão de Crises", "Curso Online", "Curso de introdução à novos voluntários a como se comportarem durante emergências",20,moduloCursoBasico);

        // Vinculando curso básico à Defesa Civil
        defesaPortoAlegre.setCursoBasico(cursoBasico);


        while (escolha.equalsIgnoreCase("sim")) {
            try{

                System.out.print("Bem-vindo ao Sistema de Voluntários da Defesa Civil \nEscolha o menu para acessar correspondente ao seu perfil: \n1) Menu da Defesa Civil \n2) Menu do Voluntário\n\n");
                System.out.print("Escolha:");
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.printf("Olá Agente %s, seja Bem-vindo!\n\nSelecione a opção desejada no menu:\n1) Criar Curso Avançado\n2) Visualizar voluntários aptos\n\n", defesaPortoAlegre.getNomeAgenteResponsavel());
                        System.out.print("Escolha:");
                        menuInterno = sc.nextInt();
                        sc.nextLine();
                        switch (menuInterno){
                            case 1:
                                System.out.println("Criação do Curso Avançado");
                                System.out.printf("Município: %s\n", defesaPortoAlegre.getMunicipio().getNome());
                                System.out.printf("Risco a ser tratado: %s\n\n", defesaPortoAlegre.getMunicipio().getTipoRisco());

                                System.out.println("Insira o nome do curso: ");
                                nomeCursoAvancado = sc.nextLine();

                                System.out.println("Insira o tipo do curso: ");
                                tipoCursoAvancado = sc.nextLine();

                                System.out.println("Insira o descricao breve do curso: ");
                                descricaoCursoAvancado = sc.nextLine();

                                System.out.println("Insira a carga horaria do curso: ");
                                cargaHorariaCursoAvancado = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Dados básicos do curso inseridos com sucesso!\n");

                                System.out.printf("Criação do Módulo do Curso %s\n", nomeCursoAvancado);
                                moduloCursoAvancado = new Modulo();

                                System.out.println("Insira o nome do módulo: ");
                                moduloCursoAvancado.setNome(sc.nextLine());

                                System.out.println("Insira o texto introdutório do módulo: ");
                                moduloCursoAvancado.setConteudoTextual(sc.nextLine());

                                System.out.println("Insira a URL do vídeo do módulo: ");
                                moduloCursoAvancado.setVideoUrl(sc.nextLine());

                                System.out.println("Módulo criado com sucesso!\n");

                                System.out.printf("Criação da Avaliação do Curso %s\n\n", nomeCursoAvancado);
                                avaliacaoCursoAvancado = new Avaliacao();

                                System.out.println("Insira a pergunta da avaliação do curso: ");
                                avaliacaoCursoAvancado.setPergunta(sc.nextLine());
                                System.out.println("Insira a alternativa A da avaliação: ");
                                avaliacaoCursoAvancado.setAlternativaA(sc.nextLine());
                                System.out.println("Insira a alternativa B da avaliacão: ");
                                avaliacaoCursoAvancado.setAlternativaB(sc.nextLine());
                                System.out.println("Insira a alternativa C da avaliação: ");
                                avaliacaoCursoAvancado.setAlternativaC(sc.nextLine());
                                System.out.println("Insira a alternativa D da avaliação: ");
                                avaliacaoCursoAvancado.setAlternativaD(sc.nextLine());

                                System.out.println("Insira a letra da alternativa correta:");
                                avaliacaoCursoAvancado.setAlternativaCorreta(sc.nextLine());

                                // Criando o curso avançado com módulo e avaliação
                                cursoAvancado = defesaPortoAlegre.criarCurso(nomeCursoAvancado,tipoCursoAvancado,descricaoCursoAvancado,cargaHorariaCursoAvancado, moduloCursoAvancado, avaliacaoCursoAvancado);
                                defesaPortoAlegre.setCursoAvancado(cursoAvancado);
                                break;
                            case 2:
                                defesaPortoAlegre.registrarVoluntario(voluntarioPortoAlegre);
                                if (defesaPortoAlegre.getVoluntario() != null) {
                                    System.out.println("Lista de Voluntários aptos:");
                                    System.out.printf("Nome: %s\n", voluntarioPortoAlegre.getNomeCompleto());
                                    System.out.printf("Data de Nascimento: %s\n", voluntarioPortoAlegre.getDataNascimento());
                                    System.out.printf("Telefone: %s\n", voluntarioPortoAlegre.getTelefone());
                                    System.out.printf("Ocupação: %s\n", voluntarioPortoAlegre.getOcupacao());
                                    System.out.printf("Habilidade: %s\n", voluntarioPortoAlegre.getHabilidade());
                                    System.out.printf("Certificado Básico em %s\n", voluntarioPortoAlegre.getCertificadoCursoBasico().getNomeCurso());
                                    System.out.printf("Certificado Avançado em %s\n", voluntarioPortoAlegre.getCertificadoCursoAvancado().getNomeCurso());

                                    dadosVoluntario = String.format("Nome: %s\nData de Nascimento: %s\nTelefone: %s\nOcupação: %s\nHabilidade: %s\nCertificado Básico em %s\nCertificado Avançado em %s\n", voluntarioPortoAlegre.getNomeCompleto(), voluntarioPortoAlegre.getDataNascimento(), voluntarioPortoAlegre.getTelefone(), voluntarioPortoAlegre.getOcupacao(), voluntarioPortoAlegre.getHabilidade(), voluntarioPortoAlegre.getCertificadoCursoBasico().getNomeCurso(), voluntarioPortoAlegre.getCertificadoCursoAvancado().getNomeCurso());

                                    System.out.println(dadosVoluntario);

                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:

                        System.out.println("Olá voluntário, seja Bem-vindo\n\nSelecione a opção desejada no menu:\n1) Registrar Voluntário\n2) Visualizar módulo e concluir curso básico \n3) Visualizar módulo curso avançado \n4) Realizar avaliação do curso avançado \n\n");
                        System.out.print("Escolha:");
                        menuInterno = sc.nextInt();
                        sc.nextLine();
                        switch (menuInterno) {
                            case 1:
                                System.out.println("Digite o seu nome completo: ");
                                voluntarioPortoAlegre.setNomeCompleto(sc.nextLine());

                                System.out.println("Digite sua data de nascimento: ");
                                formataData = LocalDate.parse(sc.nextLine(), dtf);
                                voluntarioPortoAlegre.setDataNascimento(formataData);

                                System.out.println("Digite o seu telefone: ");
                                voluntarioPortoAlegre.setTelefone(sc.nextLine());
                                System.out.println("Digite seu CPF");
                                voluntarioPortoAlegre.setCpf(sc.nextLine());
                                System.out.println("Digite o seu email: ");
                                voluntarioPortoAlegre.setEmail(sc.nextLine());
                                System.out.println("Digite sua habilidade que pode ser útil em casos de emergência: ");
                                voluntarioPortoAlegre.setHabilidade(sc.nextLine());
                                System.out.println("Digite sua ocupação: ");
                                voluntarioPortoAlegre.setOcupacao(sc.nextLine());

                                System.out.println("Voluntário cadastrado com sucesso!");
                                dadosVoluntario = String.format("Nome: %s\nData de Nascimento: %s\nTelefone: %s\nOcupação: %s\nHabilidade: %s", voluntarioPortoAlegre.getNomeCompleto(), voluntarioPortoAlegre.getDataNascimento().format(dtf), voluntarioPortoAlegre.getTelefone(), voluntarioPortoAlegre.getOcupacao(), voluntarioPortoAlegre.getHabilidade());

                                System.out.println(dadosVoluntario);

                                break;

                            case 2:
                                if (voluntarioPortoAlegre.getCpf() != null) {
                                    voluntarioPortoAlegre.setCursoBasico(cursoBasico);
                                    System.out.printf("Seja Bem-vindo ao curso Básico %s \nMódulo: %s\n\n", cursoBasico.getNome(), moduloCursoBasico.getNome());
                                    System.out.printf("Introdução: \n%s", moduloCursoBasico.getConteudoTextual());
                                    System.out.printf("\n\nVídeo do Curso: %s\n", moduloCursoBasico.getVideoUrl());
                                    System.out.println("Após visualizar o vídeo, aperte enter para concluir o curso");
                                    sc.nextLine();

                                    if (cursoBasico.concluirCurso(voluntarioPortoAlegre)) {
                                        System.out.printf("Curso %s concluído com sucesso!\n", cursoBasico.getNome());
                                    } else {
                                        throw new Exception("O curso já havia sido concluído");
                                    }
                                } else {
                                    throw new Exception("É necessário criar um voluntário antes de participar de qualquer curso");
                                }

                                break;

                            case 3:
                                if (voluntarioPortoAlegre.getCpf() != null) {
                                    if (voluntarioPortoAlegre.getCertificadoCursoBasico() != null) {

                                if (defesaPortoAlegre.getCursoAvancado() != null) {
                                    cursoAvancado = defesaPortoAlegre.getCursoAvancado();
                                    voluntarioPortoAlegre.setCursoAvancado(cursoAvancado);
                                    moduloCursoAvancado = cursoAvancado.getModulo();
                                    System.out.printf("Seja Bem-vindo ao curso Avançado %s \nMódulo: %s\n\n",cursoAvancado.getNome(), moduloCursoAvancado.getNome());

                                    System.out.printf("Introdução: \n%s", moduloCursoAvancado.getConteudoTextual());
                                    System.out.printf("\n\nVídeo do Curso: %s\n", moduloCursoAvancado.getVideoUrl());
                                    System.out.println("Após visualizar o vídeo, aperte enter para concluir o módulo");
                                    sc.nextLine();

                                    System.out.printf("Módulo %s visualizado com sucesso!\n", moduloCursoAvancado.getNome());
                                } else{
                                    throw new Exception("O módulo do Curso ainda não foi criado pela Defesa Civil\n");
                                }
                                }else{throw new Exception("O voluntário precisa ter o certificado do curso básico, para fazer o Curso Avançado\n");}
                                } else {throw new Exception("É necessário criar um voluntário antes de participar de qualquer curso");}
                                break;

                            case 4:
                                if (voluntarioPortoAlegre.getCpf() != null) {
                                    if(voluntarioPortoAlegre.getCertificadoCursoBasico() != null) {
                                if(defesaPortoAlegre.getCursoAvancado() != null) {
                                    cursoAvancado = defesaPortoAlegre.getCursoAvancado();
                                    avaliacaoCursoAvancado = cursoAvancado.getAvaliacao();
                                    System.out.printf("Avaliação do Curso: %s\n", defesaPortoAlegre.getCursoAvancado().getNome());

                                    System.out.printf("Pergunta: %s\n", avaliacaoCursoAvancado.getPergunta());

                                    System.out.printf("A) %s\n", avaliacaoCursoAvancado.getAlternativaA());
                                    System.out.printf("B) %s\n", avaliacaoCursoAvancado.getAlternativaB());
                                    System.out.printf("C) %s\n", avaliacaoCursoAvancado.getAlternativaC());
                                    System.out.printf("D) %s\n", avaliacaoCursoAvancado.getAlternativaD());

                                    System.out.print("Escolha: ");
                                    avaliacaoCursoAvancado.verificarResposta(sc.nextLine());

                                    if (avaliacaoCursoAvancado.isAcertou()) {
                                        if (cursoAvancado.concluirCurso(voluntarioPortoAlegre)) {
                                            System.out.println("Parabéns, você passou na avaliação e concluiu o curso.");
                                        } else {
                                            throw new Exception("Você ja havia concluído esse curso anteriormente\n");
                                        }
                                    } else {
                                        System.out.println("Infelizmente você não passou. Tente novamente após revisar o conteúdo.");
                                    }

                                } else{
                                    throw new Exception("Curso Avançado ainda não foi criado pela Defesa Civil\n");
                                }}else{
                                        throw new Exception("O voluntário precisa ter o certificado do curso básico, para fazer o Curso Avançado\n");}
                                } else {
                                    throw new Exception("É necessário criar um voluntário antes de participar de qualquer curso");
                                }

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
