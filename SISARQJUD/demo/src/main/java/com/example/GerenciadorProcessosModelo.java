package com.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorProcessosModelo extends Principal{
    private List<ProcessoModelo> processos;
    private List<FuncionarioModelo> funcionarios;

    public GerenciadorProcessosModelo() {
        processos = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }

    // Métodos para cadastrar processo
    public void cadastrarProcesso(ProcessoModelo processo) {
        processos.add(processo);
    }

    // Método para cadastrar funcionário
    public void cadastrarFuncionario(FuncionarioModelo funcionario) {
        funcionarios.add(funcionario);
    }

    // Método para buscar processo
    public ProcessoModelo buscarProcesso(int numero) {
        return processos.stream()
            .filter(p -> p.getNroProcesso() == numero)
            .findFirst()
            .orElse(null);
    }

    // Método para buscar funcionário por ID
    public FuncionarioModelo buscarFuncionarioPorId(int id) {
        return funcionarios.stream()
            .filter(f -> f.getId() == id)
            .findFirst()
            .orElse(null);
    }

    // Método para realizar movimentação no processo
    public void realizarMovimentacao(int numeroProcesso, FuncionarioModelo funcionario, String descricao) {
        ProcessoModelo processo = buscarProcesso(numeroProcesso);
        if (processo != null) {
            MovimentacaoModelo movimentacao = new MovimentacaoModelo(processo, funcionario, descricao, new java.util.Date());
            System.out.println("Movimentação registrada: " + movimentacao);
        } else {
            System.out.println("Processo não encontrado.");
        }
    }
}
