package br.com.fiap.main;

import br.com.fiap.bean.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        String escolha = "sim";
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Pessoa agenteDefesaMogi;
        Voluntario voluntarioMogi;
        DefesaCivilMunicipal defesaMogi;
        Curso cursoBasico, cursoIncendio;
        Modulo moduloCursoBasico;
        Avaliacao avaliacaoCursoBasico;
        Certificado certificadoCursoBasico;

        while (escolha.equalsIgnoreCase("sim")) {
            try{

                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
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
