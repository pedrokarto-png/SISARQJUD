package com.example;

import java.util.Scanner;

public class LocalizacaoModelo extends CaixaModelo {
    private String estante;
    private int prateleira;
    private int setor;

    public LocalizacaoModelo(String estante, int prateleira, int setor) {
        this.estante = estante;
        this.prateleira = prateleira;
        this.setor = setor;
    }

    public LocalizacaoModelo() {
        //TODO Auto-generated constructor stub
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public int getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(int prateleira) {
        this.prateleira = prateleira;
    }

    public int getSetor() {
        return setor;
    }

    public void setSetor(int setor) {
        this.setor = setor;
    }

    private Scanner scanner = new Scanner(System.in);

    // Método para configurar a estante a partir da entrada do usuário
    public void setEstanteFromUser() {
        System.out.println("Digite a estante:");
        this.estante = scanner.nextLine();
    }

    // Método para configurar a prateleira a partir da entrada do usuário
    public void setPrateleiraFromUser() {
        System.out.println("Digite a prateleira:");
        this.prateleira = scanner.nextInt();
        scanner.nextLine();
    }

    // Método para configurar o setor a partir da entrada do usuário
    public void setSetorFromUser() {
        System.out.println("Digite o setor:");
        this.setor = scanner.nextInt();
        scanner.nextLine();
    }

    public void setId(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
