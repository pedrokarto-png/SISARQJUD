package com.example;

import java.util.Scanner;

public class IDModelo extends MovimentacaoModelo {
    private int id;

    public IDModelo() {
        super("ID criado"); 
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Scanner scanner = new Scanner(System.in);

    // Método para configurar o ID a partir da entrada do usuário
    public void setIdFromUser() {
        System.out.println("Digite o ID:");
        this.id = (int) scanner.nextDouble();
    }

    public void setIdMov(Double novoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIdMov'");
    }
}
