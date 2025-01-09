package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParteModelo {
    private int id;
    private String nome;
    private String cpfCnpj;
    private String numero;
    private String complemento;
    private String rua;
    private String endereco;
    private String naturalidade;
    private String dataNascimento;
    private String genero;
    private String tipoParte; // Ex: "Física" ou "Jurídica"

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte) {
        this.tipoParte = tipoParte;
    }

    // Método de validação de CPF/CNPJ
    public boolean validarCpfCnpj() {
        String regexCpf = "^[0-9]{11}$"; // Apenas números para CPF
        String regexCnpj = "^[0-9]{14}$"; // Apenas números para CNPJ

        Pattern patternCpf = Pattern.compile(regexCpf);
        Matcher matcherCpf = patternCpf.matcher(cpfCnpj);
        Pattern patternCnpj = Pattern.compile(regexCnpj);
        Matcher matcherCnpj = patternCnpj.matcher(cpfCnpj);

        return matcherCpf.matches() || matcherCnpj.matches();
    }

    // Método para adicionar o nome à Parte
    public void adicionarNome(String nome) {
        this.nome = nome;
        System.out.println("Nome adicionado: " + nome);
    }

    public void setNumero(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNumero'");
    }
}
