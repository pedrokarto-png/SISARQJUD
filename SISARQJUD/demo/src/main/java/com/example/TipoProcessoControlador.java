package com.example;

import java.sql.*;
import java.util.List;

public class TipoProcessoControlador {
    private TipoProcessoModelo tipoProcessoModelo;

    public TipoProcessoControlador(TipoProcessoModelo tipoProcessoModelo) {
        this.tipoProcessoModelo = tipoProcessoModelo;
    }

    // Método para configurar o Tipo de Processo com dados fornecidos
    public void configurarTipoProcesso() {
        tipoProcessoModelo.setIdComScanner();
        tipoProcessoModelo.setClasseProcessualComScanner();
        tipoProcessoModelo.setNomeComScanner();

        // Salvar no banco de dados após configurar
        salvarTipoProcessoNoBanco();
    }

    // Método para exibir os detalhes do Tipo de Processo
    public void exibirDetalhes() {
        System.out.println("Detalhes do Tipo de Processo:");
        System.out.println("ID: " + tipoProcessoModelo.getId());
        System.out.println("Classe Processual: " + tipoProcessoModelo.getClasseProcessual());
        System.out.println("Nome: " + tipoProcessoModelo.getNome().getNome());

        // Consultar no banco de dados
        consultarTipoProcessoNoBanco();
    }

    // Método para buscar um tipo de processo por ID
    public TipoProcessoModelo buscarTipoProcessoPorId(List<TipoProcessoModelo> tiposProcessos, int id) {
        return tipoProcessoModelo.getTipoProcessoById(tiposProcessos, id);
    }

    // Método para salvar o Tipo de Processo no banco de dados
    private void salvarTipoProcessoNoBanco() {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO TipoProcesso (id, classe_processual, nome) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, tipoProcessoModelo.getId());
                stmt.setString(2, tipoProcessoModelo.getClasseProcessual());
                stmt.setString(3, tipoProcessoModelo.getNome().getNome());
                stmt.executeUpdate();
                System.out.println("Tipo de Processo salvo no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar Tipo de Processo no banco de dados.");
        }
    }

    // Método para consultar Tipo de Processo no banco de dados
    private void consultarTipoProcessoNoBanco() {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM TipoProcesso WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, tipoProcessoModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Tipo de Processo encontrado no banco de dados:");
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Classe Processual: " + rs.getString("classe_processual"));
                        System.out.println("Nome: " + rs.getString("nome"));
                    } else {
                        System.out.println("Tipo de Processo não encontrado no banco de dados.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao consultar Tipo de Processo no banco de dados.");
        }
    }
}
