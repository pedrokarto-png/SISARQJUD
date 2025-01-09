package com.example;

import java.sql.*;

public class ClasseNomeControlador {
    private ClasseNomeModelo classeNomeModelo;

    public ClasseNomeControlador(ClasseNomeModelo classeNomeModelo) {
        this.classeNomeModelo = classeNomeModelo;
    }

    public void configurarNome(String nome) {
        classeNomeModelo.setNome(nome);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE ClasseNome SET nome = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setInt(2, classeNomeModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirDetalhes() {
        System.out.println("Nome da Parte: " + classeNomeModelo.getNome());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT nome FROM ClasseNome WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, classeNomeModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Nome: " + rs.getString("nome"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ClasseNomeModelo obterClasseNomePorId(int id) {
        ClasseNomeModelo classeNome = null;

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM ClasseNome WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        classeNome = new ClasseNomeModelo();
                        classeNome.setId(rs.getInt("id"));
                        classeNome.setNome(rs.getString("nome"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classeNome;
    }
}
