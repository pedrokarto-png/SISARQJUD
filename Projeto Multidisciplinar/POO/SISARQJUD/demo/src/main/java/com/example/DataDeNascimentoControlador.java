package com.example;

import java.sql.*;
import java.text.ParseException;
import java.util.Date;

public class DataDeNascimentoControlador {

    private DataDeNascimentoModelo dataDeNascimentoModelo;

    public DataDeNascimentoControlador(DataDeNascimentoModelo dataDeNascimentoModelo) {
        this.dataDeNascimentoModelo = dataDeNascimentoModelo;
    }

    public void atualizarDataDeNascimento(String novaData) {
        try {
            Date data = DataDeNascimentoModelo.converterStringParaData(novaData);
            dataDeNascimentoModelo.setDataDeNascimento(data);
            System.out.println("Data de nascimento atualizada para: " + dataDeNascimentoModelo);

            try (Connection conexao = ConexaoBanco.getConnection()) {
                String sql = "UPDATE DataDeNascimento SET dataDeNascimento = ? WHERE id = ?";
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setDate(1, new java.sql.Date(data.getTime()));
                    stmt.setInt(2, dataDeNascimentoModelo.getId());
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
        }
    }

    public void exibirDataDeNascimento() {
        System.out.println(dataDeNascimentoModelo);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT dataDeNascimento FROM DataDeNascimento WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, dataDeNascimentoModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Data de Nascimento: " + rs.getDate("dataDeNascimento"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataDeNascimentoModelo obterDataDeNascimentoPorId(int id) {
        DataDeNascimentoModelo dataDeNascimento = null;

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM DataDeNascimento WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        dataDeNascimento = new DataDeNascimentoModelo();
                        dataDeNascimento.setId(rs.getInt("id"));
                        dataDeNascimento.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataDeNascimento;
    }
}
