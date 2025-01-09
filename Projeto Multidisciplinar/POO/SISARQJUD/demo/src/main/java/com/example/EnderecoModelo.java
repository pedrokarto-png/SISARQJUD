package com.example;

import java.util.Scanner;

public class EnderecoModelo extends ParteModelo {
    private String cep;
    private String rua;
    private String numero;
    private String complemento;

    public EnderecoModelo(String cep, String rua, String numero, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public EnderecoModelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CEP: ");
        this.setCep(scanner.nextLine());
        System.out.print("Digite o nome da rua: ");
        this.setRua(scanner.nextLine());
        System.out.print("Digite o número: ");
        this.setNumero(scanner.nextInt());
        scanner.nextLine(); 
        System.out.print("Digite o complemento (opcional): ");
        String complemento = scanner.nextLine();
        if (!complemento.isEmpty()) {
            this.setComplemento(complemento);
        }
        scanner.close();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    // Método para formatar o endereço em uma string legível
    public String formatarEndereco() {
        return rua + ", " + numero + 
               (complemento != null && !complemento.isEmpty() ? " - " + complemento : "") + 
               " - " + cep;
    }
}
