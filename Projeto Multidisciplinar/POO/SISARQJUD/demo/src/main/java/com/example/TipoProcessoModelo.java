package com.example;

import java.util.List;
import java.util.Scanner;

public class TipoProcessoModelo extends ProcessoModelo {
    private int id;
    private String classeProcessual;
    private ClasseNomeModelo nome;

    public TipoProcessoModelo(int id, String classeProcessual, ClasseNomeModelo nome) {
        super();
        this.id = id;
        this.classeProcessual = classeProcessual;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasseProcessual() {
        return classeProcessual;
    }

    public void setClasseProcessual(String classeProcessual) {
        this.classeProcessual = classeProcessual;
    }

    public ClasseNomeModelo getNome() {
        return nome;
    }

    public void setNome(ClasseNomeModelo nome) {
        this.nome = nome;
    }

    public void setIdComScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();
    scanner.close();
    }

    public void setClasseProcessualComScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a classe processual: ");
        this.classeProcessual = scanner.nextLine();
        scanner.close();
    }

    public void setNomeComScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nomeString = scanner.nextLine();
        this.nome = new ClasseNomeModelo(nomeString);
        scanner.close();
    }

    // Método para obter o tipo de processo por ID
    public TipoProcessoModelo getTipoProcessoById(List<TipoProcessoModelo> tiposProcessos, int id) {
        for (TipoProcessoModelo tipoProcesso : tiposProcessos) {
            if (tipoProcesso.getId() == id) {
                return tipoProcesso;
            }
        }
        return null;
    }
}
