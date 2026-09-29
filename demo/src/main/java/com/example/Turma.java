package com.example;

import java.util.Scanner;

public class Turma {
    private String nome;
    private Aluno[] listaAlunos;
    private int totalAlunos;

    public Turma(String nome, int quantidade){
        this.nome=nome;
        this.listaAlunos=new Aluno[quantidade];
        this.totalAlunos=0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno[] getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(Aluno[] listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public int getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public String matricularAluno(Aluno novAluno){
        int i=this.getTotalAlunos();
        String mensagem="";
        if(i<this.getListaAlunos().length){
            Aluno[] novaLista=this.getListaAlunos();
            novaLista[i]=novAluno;
            this.setListaAlunos(novaLista);
            i+=1;
            this.setTotalAlunos(i);
            mensagem="Aluno cadastrado com sucesso!";
        }else{
            mensagem="Turma está cheia e não pode cadastrar nenhum aluno!";
        }
        return mensagem;
    }

    public String criarAluno(Scanner scanner){
        //public Aluno(String nome, int quantidade)
        boolean repetir=true;
        String mensagem="";

        do {
            System.out.println("Digite o nome do novo aluno: ");
            String nome = scanner.nextLine();
            System.out.println("Digite a quantidade de avaliações do aluno: ");
            int quantidade=Integer.parseInt(scanner.nextLine());
            System.out.println("Confirma o novo cadastro?");
            System.out.println("Digite 1 para confirmar");
            System.out.println("Digite 2 para Refazer");
            System.out.println("Digite 3 para cancelar a operação");
            int opcao=Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    Aluno novoAluno=new Aluno(nome, quantidade);
                    repetir=false;
                    mensagem=this.matricularAluno(novoAluno);
                    break;
                case 2:
                    repetir=true;
                    break;
                case 3:
                    mensagem="Operação cancelada pelo usuário";
                    repetir=false;
                    break;
                default:
                    mensagem="opcão invalida. tente novamente";
                    repetir=true;
                    break;
            }
        } while (repetir==true);
        return mensagem;
    }

    public String adicionarNota(Scanner scanner){
        String mensagem="";
        
        System.out.println("Digite o codgio do aluno");
        int cod=Integer.parseInt(scanner.nextLine());
        Aluno[] lista=this.getListaAlunos();
        if(cod<0||cod>lista.length){
            mensagem="codigo invalido. tente novamente";
            //return mensagem;
        }else{
            Aluno aluno=lista[cod];
            if(aluno!=null){
                int i=aluno.getAvaliacoesFeitas();
                if(i<aluno.getNotas().length){
                    boolean repetir=true;
                    do {
                        System.out.println("Digite a nova nota para cadastrar: ");
                        double novaNota=Double.parseDouble(scanner.nextLine());
                        if(novaNota<0||novaNota>10){
                            System.out.println("Nota invalida. digite novamente");
                            repetir=true;
                        }else{
                            System.out.println("Confirmar inclusão da nova nota? Digite:");
                            System.out.println("1 - para confirmar");
                            System.out.println("2 - para alterar a nota");
                            System.out.println("3 - para cancelar");
                            int opcao=Integer.parseInt(scanner.nextLine());
                            switch (opcao) {
                                case 1:
                                    double [] novasListaNotas=aluno.getNotas();
                                    novasListaNotas[i]=novaNota;
                                    aluno.setNotas(novasListaNotas);
                                    i+=1;
                                    aluno.setAvaliacoesFeitas(i);
                                    lista[cod]=aluno;
                                    this.setListaAlunos(lista);
                                    mensagem="Nota Cadastrada com sucesso!";
                                    repetir=false;
                                    break;
                                case 2:
                                    System.out.println("alterar a nova nota");
                                    repetir=true;
                                    break;
                                case 3:
                                    mensagem="operacao cancelada pelo usuário";
                                    repetir=false;
                                    break;
                                default:
                                    System.out.println("opcao invalida. tnte novamente");
                                    repetir=true;
                                    break;
                            }  
                        }
                    } while (repetir==true);
                }else{
                    mensagem="o aluno já fez todas as avaliações. não pode cadastrar";
                }
            }else{
                mensagem="não existe aluno nessa posição";
            }
        }
        return mensagem;
    }

    public String calcularMedia(){
        Aluno[] lista=this.getListaAlunos();
        String mensagem="";
        
        for(Aluno aluno:lista){
            if(aluno!=null){
                double[]listaNotas=aluno.getNotas();
                if(listaNotas!=null){
                    double media=0;
                    for(double nota:listaNotas){
                        media=media+nota;
                    }
                    media=media/aluno.getAvaliacoesFeitas();
                    System.out.println(aluno+" - Média: "+media);
                }
            }
        }
        mensagem="fim da lista";
        return mensagem;
    }

    public String calcularMedia2(){
        String mensagem="";

        Aluno[] listaAln=this.getListaAlunos();
        for(int i=0;i<listaAln.length;i++){
            int qtd=listaAln[i].getAvaliacoesFeitas();
            double[] listaNts=listaAln[i].getNotas();
            double media=0;
            for(int j=0;j<listaNts.length;j++){
                media=media+listaNts[j];
            }
            media=media/qtd;
            System.out.println(listaAln[i]+"média="+media);
        }
        return mensagem;
    }

    public String calculaMedia3(){
        Aluno[] alunos=this.getListaAlunos();
        for(Aluno aluno:alunos){
            if(aluno==null){
                continue;
            }else{
                int qtdNotas=aluno.getAvaliacoesFeitas();
                if(qtdNotas==0){
                    System.out.println(aluno+" - media=0");
                }else{
                    double soma=0;
                    double [] listaNotas=aluno.getNotas();
                    for(double nota:listaNotas){
                        soma+=nota;
                    }
                    double media=soma/qtdNotas;
                    System.out.println(aluno+" - media: "+media);
                }
            }
        }
        String mensagem="Fim do relatório de médias";
        return mensagem;
    }

    

    public String mostrarTodosAlunos(){
        String mensagem="";

        Aluno[] lista = this.getListaAlunos();
        for(Aluno aluno:lista){
            System.out.println(aluno);
        }
        return mensagem;
    }

    

    
}
