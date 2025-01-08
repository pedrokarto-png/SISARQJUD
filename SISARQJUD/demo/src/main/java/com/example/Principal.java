package com.example;

import java.sql.*;

public class Principal {

    private static final String URL = "jdbc:postgresql://localhost:5432/SISARQJUDv5";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (conexao != null) {
                System.out.println("Conexão realizada com sucesso!");
            } else {
                System.out.println("Erro ao conectar ao Banco de dados!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GerenciadorProcessosModelo modelo = new GerenciadorProcessosModelo();
        GerenciadorProcessosControlador controlador = new GerenciadorProcessosControlador(modelo);
        controlador.exibirMenu();
    } 
}