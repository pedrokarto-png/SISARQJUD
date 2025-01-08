package com.example;

import java.sql.*;
import java.util.Scanner;

public class TelefoneControlador {
    private TelefoneModelo telefoneModelo;
    private Scanner scanner = new Scanner(System.in);

    public TelefoneControlador(TelefoneModelo telefoneModelo) {
        this.telefoneModelo = telefoneModelo;
    }

    // Método para configurar o telefone (entrada do usuário)
    public void configurarTelefone() {
        System.out.print("Digite o DDD: ");
        telefoneModelo.setDdd(scanner.nextLine());
        System.out.print("Digite o número: ");
        telefoneModelo.setNumero(scanner.nextLine());

        // Salvar os dados no banco
        salvarTelefoneNoBanco();
    }

    // Método para exibir os detalhes do telefone
    public void exibirDetalhes() {
        // Exibir detalhes da instância local
        System.out.println("Detalhes do Telefone:");
        System.out.println("DDD: " + telefoneModelo.getDdd());
        System.out.println("Número: " + telefoneModelo.getNumero());

        // Consultar os detalhes do banco de dados
        consultarTelefoneDoBanco();
    }

    // Método para salvar telefone no banco de dados
    private void salvarTelefoneNoBanco() {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Telefone (ddd, numero) VALUES (?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, telefoneModelo.getDdd());
                stmt.setString(2, telefoneModelo.getNumero());
                stmt.executeUpdate();
                System.out.println("Telefone salvo no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar telefone no banco de dados.");
        }
    }

    // Método para consultar telefone no banco de dados e exibir detalhes
    private void consultarTelefoneDoBanco() {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Telefone WHERE ddd = ? AND numero = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, telefoneModelo.getDdd());
                stmt.setString(2, telefoneModelo.getNumero());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Telefone encontrado no banco de dados:");
                        System.out.println("DDD: " + rs.getString("ddd"));
                        System.out.println("Número: " + rs.getString("numero"));
                    } else {
                        System.out.println("Telefone não encontrado no banco de dados.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar telefone no banco de dados.");
        }
    }
}
