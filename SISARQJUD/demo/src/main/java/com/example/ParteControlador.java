package com.example;

import java.io.File;
import java.sql.*;

public class ParteControlador {

    private ParteModelo parteModelo;

    public ParteControlador(ParteModelo parteModelo) {
        this.parteModelo = parteModelo;
    }

    // Método para atualizar informações da Parte no banco de dados
    public void atualizarInformacoes(String nome, String cpfCnpj) {
        parteModelo.setNome(nome);
        parteModelo.setCpfCnpj(cpfCnpj);
        System.out.println("Informações atualizadas: Nome - " + nome + ", CPF/CNPJ - " + cpfCnpj);

        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "UPDATE Parte SET nome = ?, CPF_CNPJ = ? WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, nome);
                stmt.setString(2, cpfCnpj);
                stmt.setInt(3, parteModelo.getId());
                stmt.executeUpdate();
                System.out.println("Informações no banco de dados atualizadas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar documentos associados à Parte
    public void carregarDocumento(File documento) {
        String nomeArquivo = documento.getName();
        if (nomeArquivo.endsWith(".pdf") || nomeArquivo.endsWith(".xlsx") || nomeArquivo.endsWith(".txt")) {
            System.out.println("Documento '" + nomeArquivo + "' carregado com sucesso.");
        } else {
            System.out.println("Formato de arquivo inválido. Aceitos: PDF, XLSX, TXT.");
        }
    }

    // Método para exibir os detalhes da Parte
    public void exibirDetalhes() {
        System.out.println("Detalhes da Parte:");
        System.out.println("Nome: " + parteModelo.getNome());
        System.out.println("CPF/CNPJ: " + parteModelo.getCpfCnpj());
        System.out.println("Data de Nascimento: " + parteModelo.getDataNascimento());
        System.out.println("Naturalidade: " + parteModelo.getNaturalidade());
        System.out.println("Gênero: " + parteModelo.getGenero());
        System.out.println("Tipo de Parte: " + parteModelo.getTipoParte());
    }

    // Método para validar o CPF ou CNPJ
    public boolean validarDocumento() {
        boolean valido = parteModelo.validarCpfCnpj();
        System.out.println("CPF/CNPJ válido: " + valido);
        return valido;
    }

    // Método para consultar Parte no banco de dados
    public void consultarParteNoBanco() {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM Parte WHERE id = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, parteModelo.getId());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        parteModelo.setNome(rs.getString("nome"));
                        parteModelo.setCpfCnpj(rs.getString("CPF_CNPJ"));
                        parteModelo.setNumero(rs.getInt("numero"));
                        parteModelo.setComplemento(rs.getString("complemento"));
                        parteModelo.setRua(rs.getString("rua"));
                        parteModelo.setEndereco(rs.getString("endereco"));
                        parteModelo.setNaturalidade(rs.getString("naturalidade"));
                        System.out.println("Parte consultada no banco de dados.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir uma nova Parte no banco de dados
    public void inserirParteNoBanco() {
        try (Connection conexao = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO Parte (nome, CPF_CNPJ, numero, complemento, rua, endereco, naturalidade) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, parteModelo.getNome());
                stmt.setString(2, parteModelo.getCpfCnpj());
                stmt.setString(3, parteModelo.getNumero());
                stmt.setString(4, parteModelo.getComplemento());
                stmt.setString(5, parteModelo.getRua());
                stmt.setString(6, parteModelo.getEndereco());
                stmt.setString(7, parteModelo.getNaturalidade());
                stmt.executeUpdate();
                System.out.println("Parte inserida no banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
