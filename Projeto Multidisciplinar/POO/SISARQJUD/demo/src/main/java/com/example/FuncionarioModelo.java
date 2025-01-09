package com.example;

import java.util.Date;

public class FuncionarioModelo {
    private int codVerificacao;
    private String nome;
    private Date dataNascimento;
    private String cargo;

    public FuncionarioModelo() {}

    public FuncionarioModelo(int codVerificacao, String nome, Date dataNascimento, String cargo) {
        this.codVerificacao = codVerificacao;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
    }

    public FuncionarioModelo(int codVerificacao, String nome, String cargo) {
        this.codVerificacao = codVerificacao;
        this.nome = nome;
        this.cargo = cargo;
    }

    public int getCodVerificacao() {
        return codVerificacao;
    }

    public void setCodVerificacao(int codVerificacao) {
        this.codVerificacao = codVerificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Método 'getId' ainda não implementado.");
    }

    public void setId(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
