package com.example;

import java.sql.*;

public class FuncionarioControlador {
    private FuncionarioModelo funcionarioModelo;

    public FuncionarioControlador(FuncionarioModelo funcionarioModelo) {
        this.funcionarioModelo = funcionarioModelo;
    }

    public void atualizarCodVerificacao(int novoCodVerificacao) {
        funcionarioModelo.setCodVerificacao(novoCodVerificacao);
        System.out.println("Código de verificação atualizado para: " + novoCodVerificacao);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Funcionario SET cod_verificacao = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, novoCodVerificacao);
                stmt.setInt(2, funcionarioModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNome(String novoNome) {
        funcionarioModelo.setNome(novoNome);
        System.out.println("Nome atualizado para: " + novoNome);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Funcionario SET nome = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novoNome);
                stmt.setInt(2, funcionarioModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarDataNascimento(Date novaDataNascimento) {
        funcionarioModelo.setDataNascimento(novaDataNascimento);
        System.out.println("Data de nascimento atualizada para: " + novaDataNascimento);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Funcionario SET data_nascimento = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setDate(1, new java.sql.Date(novaDataNascimento.getTime()));
                stmt.setInt(2, funcionarioModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCargo(String novoCargo) {
        funcionarioModelo.setCargo(novoCargo);
        System.out.println("Cargo atualizado para: " + novoCargo);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Funcionario SET cargo = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novoCargo);
                stmt.setInt(2, funcionarioModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirInformacoes() {
        System.out.println("Funcionário: ");
        System.out.println("Código de Verificação: " + funcionarioModelo.getCodVerificacao());
        System.out.println("Nome: " + funcionarioModelo.getNome());
        if (funcionarioModelo.getDataNascimento() != null) {
            System.out.println("Data de Nascimento: " + funcionarioModelo.getDataNascimento());
        }
        System.out.println("Cargo: " + funcionarioModelo.getCargo());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Funcionario WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, funcionarioModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Funcionário encontrado no banco de dados:");
                        System.out.println("Código de Verificação: " + rs.getInt("cod_verificacao"));
                        System.out.println("Nome: " + rs.getString("nome"));
                        System.out.println("Data de Nascimento: " + rs.getDate("data_nascimento"));
                        System.out.println("Cargo: " + rs.getString("cargo"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FuncionarioModelo getFuncionarioModelo() {
        return funcionarioModelo;
    }

    public static FuncionarioModelo obterFuncionarioPorId(int id) {
        FuncionarioModelo funcionario = null;

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Funcionario WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        funcionario = new FuncionarioModelo();
                        funcionario.setId(rs.getInt("id"));
                        funcionario.setCodVerificacao(rs.getInt("cod_verificacao"));
                        funcionario.setNome(rs.getString("nome"));
                        funcionario.setDataNascimento(rs.getDate("data_nascimento"));
                        funcionario.setCargo(rs.getString("cargo"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }
}
