package com.example;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Scanner scanner=new Scanner(System.in);
        boolean continua = true;

        System.out.println("Digite o nome da turna:");
        String nome=scanner.nextLine();
        System.out.println("Digite a quantidade de alunos da turma");
        int quantidade=Integer.parseInt(scanner.nextLine());
        Turma turma = new Turma(nome, quantidade);

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("Digite:");
            System.out.println("1 -Matricular Novo Aluno");
            System.out.println("2 - Adicionar nota de aluno");
            System.out.println("3 - Calcular média de todos os alunos");
            System.out.println("4 - Mostrar todos alunos matriculados");
            System.out.println("5 - Sair");

            int escolha=Integer.parseInt(scanner.nextLine());
            String resposta="";

            switch (escolha) {
                case 1:
                    resposta=turma.criarAluno(scanner);
                    System.out.println(resposta);
                    continua=true;
                    break;
                
                case 2:
                    resposta=turma.adicionarNota(scanner);
                    System.out.println(resposta);
                    continua=true;
                    break;
                
                case 3:
                    resposta=turma.calculaMedia3();
                    System.out.println(resposta);
                    continua=true;
                    break;
                
                case 4:
                    resposta=turma.mostrarTodosAlunos();
                    System.out.println(resposta);
                    continua=true;
                    break;

                case 5:
                    resposta="Programa encerrado pelo usuário";
                    System.out.println(resposta);
                    continua=false;
                    break;

                default:
                    resposta="opção invalida. tente novamente";
                    System.out.println(resposta);
                    continua=true;
                    break;
            }

        } while (continua==true);
    }
}
