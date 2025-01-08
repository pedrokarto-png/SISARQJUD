package com.example;

import java.util.Scanner;
public class TelefoneModelo extends ParteModelo {
    private String ddd;
    private String numero;

    public TelefoneModelo(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public TelefoneModelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o DDD: ");
        this.setDdd(scanner.nextLine());
        System.out.print("Digite o número: ");
        this.setNumero(scanner.nextLine());
        scanner.close();
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
