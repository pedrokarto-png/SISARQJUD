import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Módulo de Gerenciamento de Processos
public class GerenciadorProcessos {
    private List<Processo> processos;
    private List<Funcionario> funcionarios;

    public GerenciadorProcessos() {
        processos = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }

    // Método para cadastrar processo
    public void cadastrarProcesso(Processo processo) {
        processos.add(processo);
        System.out.println("Processo cadastrado com sucesso!");
    }

    // Método para cadastrar funcionário
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Método para buscar processo
    public Processo buscarProcesso(int numero) {
        return processos.stream()
            .filter(p -> p.getNroProcesso() == numero)
            .findFirst()
            .orElse(null);
    }

    // Método para realizar movimentação
    public void realizarMovimentacao(int numeroProcesso, Funcionario funcionario, String descricao) {
        Processo processo = buscarProcesso(numeroProcesso);
        if (processo != null) {
            Movimentacao movimentacao = new Movimentacao(
                processo,
                funcionario, 
                descricao, 
                new Date()
            );
            System.out.println("Movimentação registrada: " + movimentacao);
        } else {
            System.out.println("Processo não encontrado.");
        }
    }
}

// Módulo de Interface com Usuário
class InterfaceUsuario {
    private Scanner scanner;
    private GerenciadorProcessos gerenciador;

    public InterfaceUsuario(GerenciadorProcessos gerenciador) {
        this.scanner = new Scanner(System.in);
        this.gerenciador = gerenciador;
    }

    // Menu principal
    public void exibirMenu() {
        while (true) {
            System.out.println("\n-------------- SISARQJUD -------------");
            System.out.println("\n--- SISTEMA DE GESTÃO DE PROCESSOS ---");
            System.out.println("1. Cadastrar Processo");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Realizar Movimentação");
            System.out.println("4. Buscar Processo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: cadastrarProcesso(); break;
                case 2: cadastrarFuncionario(); break;
                case 3: realizarMovimentacao(); break;
                case 4: buscarProcesso(); break;
                case 5: 
                    System.out.println("Encerrando o sistema...");
                    return;
                default: 
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarProcesso() {
        // Implementação simplificada
        System.out.print("Número do Processo: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Vara de Origem: ");
        String varaOrigem = scanner.nextLine();

        Processo processo = new Processo(numero, varaOrigem, "", "", "", 1);
        gerenciador.cadastrarProcesso(processo);
    }

    private void cadastrarFuncionario() {
        // Implementação simplificada
        System.out.print("Nome do Funcionário: ");
        String nome = scanner.nextLine();
        
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        Funcionario funcionario = new Funcionario(0, nome, cargo);
        gerenciador.cadastrarFuncionario(funcionario);
    }

    private void realizarMovimentacao() {
        System.out.print("Número do Processo: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Funcionário: ");
        int idFuncionario = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descrição da Movimentação: ");
        String descricao = scanner.nextLine();

        /*  NATANNY
            Na prática, você buscaria o funcionário por ID, adicionar classe ID e ajustar o código
         */  
        Funcionario funcionario = new Funcionario(idFuncionario, "Nome Exemplo", "Cargo Exemplo");
        
        gerenciador.realizarMovimentacao(numero, funcionario, descricao);
    }

    private void buscarProcesso() {
        System.out.print("Número do Processo: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Processo processo = gerenciador.buscarProcesso(numero);
        if (processo != null) {
            System.out.println("Processo encontrado: " + processo);
        } else {
            System.out.println("Processo não encontrado.");
        }
    }
}