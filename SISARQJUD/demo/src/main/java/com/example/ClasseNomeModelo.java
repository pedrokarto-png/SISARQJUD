package com.example;


public class ClasseNomeModelo extends ParteModelo {
    private String nome;

    public ClasseNomeModelo(String nome) {
        super(); 
        this.nome = nome;
        adicionarNomeNaParte(nome);
   }

    public ClasseNomeModelo() {
        //TODO Auto-generated constructor stub
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        adicionarNomeNaParte(nome); // Atualiza o nome na parte
    }

    protected void adicionarNomeNaParte(String nome) {
    }
}
