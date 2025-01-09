package com.example;

import java.sql.*;

public class IDControlador {
    private IDModelo idModelo;

    public IDControlador(IDModelo idModelo) {
        this.idModelo = idModelo;
    }

    public void atualizarId(Double novoId) {
        idModelo.setIdMov(novoId);
        System.out.println("ID atualizado para: " + novoId);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE ID SET id = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setDouble(1, novoId);
                stmt.setDouble(2, idModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void capturarIdDoUsuario() {
        idModelo.setIdFromUser();
        System.out.println("ID capturado: " + idModelo.getId());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO ID (id) VALUES (?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setDouble(1, idModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirId() {
        System.out.println("ID atual: " + idModelo.getId());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM ID WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setDouble(1, idModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("ID encontrado no banco de dados:");
                        System.out.println("ID: " + rs.getDouble("id"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public IDModelo getIdModelo() {
        return idModelo;
    }

    public static IDModelo obterIdPorId(Double id) {
        IDModelo idModelo = null;

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM ID WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setDouble(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        idModelo = new IDModelo();
                        idModelo.setId((int) rs.getDouble("id"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idModelo;
    }
}
