package com.example;

import java.sql.*;
import java.util.Scanner;

public class GerenciadorProcessosControlador {
    private GerenciadorProcessosModelo modelo;
    private Scanner scanner;

    public GerenciadorProcessosControlador(GerenciadorProcessosModelo modelo) {
        this.modelo = modelo;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n-------------- SISARQJUD -------------");
            System.out.println("--- SISTEMA DE GESTÃO DE PROCESSOS ---");
            System.out.println("1. Cadastrar Processo");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Realizar Movimentação");
            System.out.println("4. Buscar Processo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: cadastrarProcesso(); break;
                case 2: cadastrarFuncionario(); break;
                case 3: realizarMovimentacao(); break;
                case 4: buscarProcesso(); break;
                case 5: 
                    System.out.println("Encerrando o sistema...");
                    return;
                default: 
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Método para cadastrar um processo no banco de dados
    private void cadastrarProcesso() {
        System.out.print("Número do Processo: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Vara de Origem: ");
        String varaOrigem = scanner.nextLine();

        ProcessoModelo processo = new ProcessoModelo(numero, varaOrigem, "Tipo", "Sigilo", "Sentença", 1);
        modelo.cadastrarProcesso(processo);
        salvarProcessoNoBanco(processo);
        System.out.println("Processo cadastrado com sucesso!");
    }

    // Método para cadastrar um funcionário no banco de dados
    private void cadastrarFuncionario() {
        System.out.print("Nome do Funcionário: ");
        String nome = scanner.nextLine();
        
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        FuncionarioModelo funcionario = new FuncionarioModelo(0, nome, cargo);
        modelo.cadastrarFuncionario(funcionario);
        salvarFuncionarioNoBanco(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Método para realizar uma movimentação de processo
    private void realizarMovimentacao() {
        System.out.print("Número do Processo: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("ID do Funcionário: ");
        int idFuncionario = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Descrição da Movimentação: ");
        String descricao = scanner.nextLine();

        FuncionarioModelo funcionario = modelo.buscarFuncionarioPorId(idFuncionario);
        
        if (funcionario != null) {
            modelo.realizarMovimentacao(numero, funcionario, descricao);
            salvarMovimentacaoNoBanco(numero, funcionario, descricao);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Método para buscar um processo no banco de dados
    private void buscarProcesso() {
        System.out.print("Número do Processo: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        ProcessoModelo processo = modelo.buscarProcesso(numero);
        if (processo != null) {
            System.out.println("Processo encontrado: " + processo);
        } else {
            System.out.println("Processo não encontrado.");
        }
    }

    // Função para salvar um processo no banco de dados
    private void salvarProcessoNoBanco(ProcessoModelo processo) {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Processo (nro_processo, vara_origem, tipo_processo, sigilo, sentenca, volume) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, processo.getNroProcesso());
                stmt.setString(2, processo.getVaraOrigem());
                stmt.setString(4, processo.getSigilo());
                stmt.setString(5, processo.getSentenca());
                stmt.setInt(6, processo.getVolume());
                stmt.executeUpdate();
                System.out.println("Processo salvo no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar Processo no banco de dados.");
        }
    }

    // Função para salvar um funcionário no banco de dados
    private void salvarFuncionarioNoBanco(FuncionarioModelo funcionario) {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Funcionario (nome, cargo) VALUES (?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCargo());
                stmt.executeUpdate();
                System.out.println("Funcionário salvo no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar Funcionário no banco de dados.");
        }
    }

    // Função para salvar uma movimentação no banco de dados
    private void salvarMovimentacaoNoBanco(int numeroProcesso, FuncionarioModelo funcionario, String descricao) {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Movimentacao (processo_id, funcionario_nome, descricao) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, numeroProcesso);
                stmt.setString(2, funcionario.getNome());
                stmt.setString(3, descricao);
                stmt.executeUpdate();
                System.out.println("Movimentação registrada no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao registrar Movimentação no banco de dados.");
        }
    }
}
