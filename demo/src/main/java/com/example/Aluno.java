package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class Aluno {
    private String nome;
    private double[] notas;
    private int avaliacoesFeitas;

    public Aluno(String nome, int quantidade){
        this.nome=nome;
        this.notas=new double[quantidade];
        this.avaliacoesFeitas=0;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getNome(){
        return this.nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public int getAvaliacoesFeitas() {
        return avaliacoesFeitas;
    }

    public void setAvaliacoesFeitas(int avaliacoesFeitas) {
        this.avaliacoesFeitas = avaliacoesFeitas;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", notas=" + Arrays.toString(notas) + "]";
    }

    



    
}
