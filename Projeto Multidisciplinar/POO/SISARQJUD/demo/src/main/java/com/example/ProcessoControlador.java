package com.example;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProcessoControlador {
    private ProcessoModelo processoModelo;
    private Scanner scanner = new Scanner(System.in);

    public ProcessoControlador(ProcessoModelo processoModelo) {
        this.processoModelo = processoModelo;
    }
    @SuppressWarnings("unused")
    private int obterNumeroProcesso() {
        int numero = -1;
        while (numero == -1) {
            try {
                System.out.print("Digite um número inteiro: ");
                numero = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro válido.");
                scanner.nextLine();
            }
        }
        return numero;
    }

    // Método para realizar uma movimentação no processo
    public void realizarMovimentacao(String tipoMovimentacao, FuncionarioModelo funcionario, String data) {
        if (tipoMovimentacao == null || tipoMovimentacao.isEmpty()) {
            throw new IllegalArgumentException("Tipo de movimentação não pode ser vazio");
        }

        // Logic for the movimentação
        System.out.println("Processo " + processoModelo.getNroProcesso() + " movimentado para " + tipoMovimentacao
            + " por " + funcionario.getNome() + " em " + data);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Movimentacao (processo_id, tipo_movimentacao, funcionario_nome, data_movimentacao) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, processoModelo.getNroProcesso());
                stmt.setString(2, tipoMovimentacao);
                stmt.setString(3, funcionario.getNome());
                stmt.setString(4, data);
                stmt.executeUpdate();
                System.out.println("Movimentação registrada no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Refactor to use separate method for fetching a process
    public ProcessoModelo buscarProcessoPorNumero(List<ProcessoModelo> processos, int numeroProcesso) {
        for (ProcessoModelo processo : processos) {
            if (processo.getNroProcesso() == numeroProcesso) {
                return processo;
            }
        }
        return null;
    }

    // Exemplo de um método genérico para consultar no banco
    public ProcessoModelo consultarProcessoPorId(int processoId) {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Processo WHERE nro_processo = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, processoId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        ProcessoModelo processo = new ProcessoModelo();
                        processo.setNroProcesso(rs.getInt("nro_processo"));
                        processo.setVaraOrigem(rs.getString("vara_origem"));
                        processo.setTipoProcesso(rs.getString("tipo_processo"));
                        processo.setSigilo(rs.getString("sigilo"));
                        processo.setSentenca(rs.getString("sentenca"));
                        processo.setVolume(rs.getInt("volume"));
                        return processo;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
