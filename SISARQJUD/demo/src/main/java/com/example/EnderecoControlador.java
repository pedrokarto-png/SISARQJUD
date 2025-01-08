package com.example;

import java.sql.*;

public class EnderecoControlador {
    private EnderecoModelo enderecoModelo;

    public EnderecoControlador(EnderecoModelo enderecoModelo) {
        this.enderecoModelo = enderecoModelo;
    }

    public void atualizarCep(String novoCep) {
        enderecoModelo.setCep(novoCep);
        System.out.println("CEP atualizado para: " + novoCep);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Endereco SET cep = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novoCep);
                stmt.setInt(2, enderecoModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarRua(String novaRua) {
        enderecoModelo.setRua(novaRua);
        System.out.println("Rua atualizada para: " + novaRua);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Endereco SET rua = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novaRua);
                stmt.setInt(2, enderecoModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNumero(int novoNumero) {
        enderecoModelo.setNumero(novoNumero);
        System.out.println("Número atualizado para: " + novoNumero);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Endereco SET numero = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, novoNumero);
                stmt.setInt(2, enderecoModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarComplemento(String novoComplemento) {
        enderecoModelo.setComplemento(novoComplemento);
        System.out.println("Complemento atualizado para: " + novoComplemento);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Endereco SET complemento = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, novoComplemento);
                stmt.setInt(2, enderecoModelo.getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirEnderecoFormatado() {
        System.out.println("Endereço formatado: " + enderecoModelo.formatarEndereco());

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Endereco WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, enderecoModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String enderecoFormatado = rs.getString("rua") + ", " + rs.getInt("numero") +
                            " - " + rs.getString("complemento") + " - " + rs.getString("cep");
                        System.out.println("Endereço: " + enderecoFormatado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EnderecoModelo getEnderecoModelo() {
        return enderecoModelo;
    }

    public static EnderecoModelo obterEnderecoPorId(int id) {
        EnderecoModelo endereco = null;

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Endereco WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        endereco = new EnderecoModelo();
                        endereco.setId(rs.getInt("id"));
                        endereco.setRua(rs.getString("rua"));
                        endereco.setNumero(rs.getInt("numero"));
                        endereco.setComplemento(rs.getString("complemento"));
                        endereco.setCep(rs.getString("cep"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }
}
