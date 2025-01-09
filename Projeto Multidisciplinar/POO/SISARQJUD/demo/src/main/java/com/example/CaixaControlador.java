package com.example;

import java.sql.*;

public class CaixaControlador {
    private CaixaModelo caixa;

    public CaixaControlador(CaixaModelo caixa) {
        this.caixa = caixa;
    }

    // Método para vincular uma parte à caixa
    public void vincularParte(String parte) {
        if (!caixa.getParte().contains(parte)) {
            caixa.adicionarParte(parte);
            System.out.println("Parte vinculada com sucesso.");

            // Atualizando no banco de dados
            try (Connection conexao = ConexaoBanco.getConnection()) {
                String sql = "INSERT INTO Caixa_Parte (caixa_id, parte) VALUES (?, ?)";
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, caixa.getId());  // Supondo que CaixaModelo tenha um método getId()
                    stmt.setString(2, parte);
                    stmt.executeUpdate();
                    System.out.println("Parte vinculada no banco de dados.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Parte já está vinculada.");
        }
    }

    // Método para desvincular uma parte da caixa
    public void desvincularParte(CharSequence parte) {
        if (caixa.getParte().contains(parte)) {
            caixa.excluirParte(parte);
            System.out.println("Parte desvinculada com sucesso.");

            // Removendo do banco de dados
            try (Connection conexao = ConexaoBanco.getConnection()) {
                String sql = "DELETE FROM Caixa_Parte WHERE caixa_id = ? AND parte = ?";
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, caixa.getId());
                    stmt.setString(2, parte.toString());
                    stmt.executeUpdate();
                    System.out.println("Parte desvinculada do banco de dados.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Parte não está vinculada.");
        }
    }

    // Método para verificar se a caixa está ocupada
    public boolean verificarOcupacao() {
        // Consultando o banco de dados para verificar ocupação
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT ocupada FROM Caixa WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, caixa.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getBoolean("ocupada");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retorna falso se não encontrar
    }

    // Método para atualizar a localização da caixa
    public void atualizarLocalizacao(String novaLocalizacao) {
        caixa.setLocalizacao(novaLocalizacao);
        System.out.println("Localização atualizada para: " + novaLocalizacao);

        // Atualizando no banco de dados
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Caixa SET localizacao = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novaLocalizacao);
                stmt.setInt(2, caixa.getId());
                stmt.executeUpdate();
                System.out.println("Localização da caixa atualizada no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar a etiqueta da caixa
    public void atualizarEtiqueta(String novaEtiqueta) {
        caixa.setEtiqueta(novaEtiqueta);
        System.out.println("Etiqueta atualizada para: " + novaEtiqueta);

        // Atualizando no banco de dados
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Caixa SET etiqueta = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novaEtiqueta);
                stmt.setInt(2, caixa.getId());
                stmt.executeUpdate();
                System.out.println("Etiqueta da caixa atualizada no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para retornar o objeto caixa
    public CaixaModelo getCaixa() {
        return caixa;
    }

    // Método para obter a caixa pelo ID no banco de dados
    public static CaixaModelo obterCaixaPorId(int id) {
        CaixaModelo caixaEncontrada = null;
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Caixa WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        caixaEncontrada = new CaixaModelo();
                        caixaEncontrada.setLocalizacao(rs.getString("localizacao"));
                        caixaEncontrada.setEtiqueta(rs.getString("etiqueta"));
                        caixaEncontrada.setOcupada(rs.getBoolean("ocupada"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caixaEncontrada;
    }
}
