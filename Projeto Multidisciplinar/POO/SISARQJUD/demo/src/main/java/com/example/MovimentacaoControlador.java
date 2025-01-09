package com.example;

import java.sql.*;
import java.io.File;

public class MovimentacaoControlador {
    private MovimentacaoModelo movimentacaoModelo;

    public MovimentacaoControlador(MovimentacaoModelo movimentacaoModelo) {
        this.movimentacaoModelo = movimentacaoModelo;
    }

    public void atualizarTipoMov(String novoTipoMov) {
        movimentacaoModelo.setTipoMov(novoTipoMov);
        System.out.println("Tipo de movimentação atualizado para: " + novoTipoMov);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Movimentacao SET tipoMov = ? WHERE idMov = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novoTipoMov);
                stmt.setInt(2, movimentacaoModelo.getIdMov());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirDetalhesMovimentacao() {
        System.out.println("Detalhes da Movimentação:");
        System.out.println("ID: " + movimentacaoModelo.getIdMov());
        System.out.println("Tipo: " + movimentacaoModelo.getTipoMov());
        System.out.println("Data: " + movimentacaoModelo.getData());
        System.out.println("Responsável: " + movimentacaoModelo.getResponsavel().getNome());
        System.out.println("Processo: " + movimentacaoModelo.getProcesso().getDescricao());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Movimentacao WHERE idMov = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, movimentacaoModelo.getIdMov());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Movimentação encontrada no banco de dados:");
                        System.out.println("ID: " + rs.getInt("idMov"));
                        System.out.println("Tipo: " + rs.getString("tipoMov"));
                        System.out.println("Data: " + rs.getDate("data"));
                        // Adicionar mais campos conforme necessário
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void carregarDocumento(File documento) {
        movimentacaoModelo.uploadDocumento(documento);
        
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Documentos (idMov, documento) VALUES (?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, movimentacaoModelo.getIdMov());
                stmt.setBinaryStream(2, new java.io.FileInputStream(documento));
                stmt.executeUpdate();
            }
        } catch (SQLException | java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void associarMovimentacao(ProcessoModelo processo) {
        movimentacaoModelo.setProcesso(processo);
        System.out.println("Movimentação associada ao processo: " + processo.getDescricao());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Movimentacao SET processo_id = ? WHERE idMov = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, processo.getId());
                stmt.setInt(2, movimentacaoModelo.getIdMov());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarResponsavel(FuncionarioModelo novoResponsavel) {
        movimentacaoModelo.setResponsavel(novoResponsavel);
        System.out.println("Responsável atualizado para: " + novoResponsavel.getNome());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Movimentacao SET responsavel_id = ? WHERE idMov = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, novoResponsavel.getId());
                stmt.setInt(2, movimentacaoModelo.getIdMov());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MovimentacaoModelo getMovimentacaoModelo() {
        return movimentacaoModelo;
    }

    public static MovimentacaoModelo obterMovimentacaoPorId(int id) {
        MovimentacaoModelo movimentacaoModelo = null;

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Movimentacao WHERE idMov = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        movimentacaoModelo = new MovimentacaoModelo(sql);
                        movimentacaoModelo.setIdMov(rs.getInt("idMov"));
                        movimentacaoModelo.setTipoMov(rs.getString("tipoMov"));
                        movimentacaoModelo.setData(rs.getDate("data"));
                        // Preencher outros campos conforme necessário
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movimentacaoModelo;
    }
}
