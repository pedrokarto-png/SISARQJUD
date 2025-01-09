package com.example;

import java.sql.*;

public class LocalizacaoControlador {
    private LocalizacaoModelo localizacaoModelo;

    public LocalizacaoControlador(LocalizacaoModelo localizacaoModelo) {
        this.localizacaoModelo = localizacaoModelo;
    }

    public void atualizarEstante(String novaEstante) {
        localizacaoModelo.setEstante(novaEstante);
        System.out.println("Estante atualizada para: " + novaEstante);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Localizacao SET estante = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novaEstante);
                stmt.setInt(2, localizacaoModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPrateleira(int novaPrateleira) {
        localizacaoModelo.setPrateleira(novaPrateleira);
        System.out.println("Prateleira atualizada para: " + novaPrateleira);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Localizacao SET prateleira = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, novaPrateleira);
                stmt.setInt(2, localizacaoModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarSetor(int novoSetor) {
        localizacaoModelo.setSetor(novoSetor);
        System.out.println("Setor atualizado para: " + novoSetor);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Localizacao SET setor = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, novoSetor);
                stmt.setInt(2, localizacaoModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void capturarEstanteDoUsuario() {
        localizacaoModelo.setEstanteFromUser();
        System.out.println("Estante capturada: " + localizacaoModelo.getEstante());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Localizacao (estante) VALUES (?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, localizacaoModelo.getEstante());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void capturarPrateleiraDoUsuario() {
        localizacaoModelo.setPrateleiraFromUser();
        System.out.println("Prateleira capturada: " + localizacaoModelo.getPrateleira());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Localizacao (prateleira) VALUES (?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, localizacaoModelo.getPrateleira());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void capturarSetorDoUsuario() {
        localizacaoModelo.setSetorFromUser();
        System.out.println("Setor capturado: " + localizacaoModelo.getSetor());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Localizacao (setor) VALUES (?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, localizacaoModelo.getSetor());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirLocalizacao() {
        System.out.println("Localização: ");
        System.out.println("Estante: " + localizacaoModelo.getEstante());
        System.out.println("Prateleira: " + localizacaoModelo.getPrateleira());
        System.out.println("Setor: " + localizacaoModelo.getSetor());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Localizacao WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, localizacaoModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Localização encontrada no banco de dados:");
                        System.out.println("Estante: " + rs.getString("estante"));
                        System.out.println("Prateleira: " + rs.getInt("prateleira"));
                        System.out.println("Setor: " + rs.getInt("setor"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LocalizacaoModelo getLocalizacaoModelo() {
        return localizacaoModelo;
    }

    public static LocalizacaoModelo obterLocalizacaoPorId(int id) {
        LocalizacaoModelo localizacaoModelo = null;

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Localizacao WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        localizacaoModelo = new LocalizacaoModelo();
                        localizacaoModelo.setId(rs.getInt("id"));
                        localizacaoModelo.setEstante(rs.getString("estante"));
                        localizacaoModelo.setPrateleira(rs.getInt("prateleira"));
                        localizacaoModelo.setSetor(rs.getInt("setor"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localizacaoModelo;
    }
}
