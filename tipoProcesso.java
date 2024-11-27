import java.util.Scanner;

public class tipoProcesso extends Processo{
    private int id;
    private String classeProcessual;
    private Nome nome;

    public TipoProcesso(int id, String classeProcessual, Nome nome) {
        this.id = id;
        this.classeProcessual = classeProcessual;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getClasseProcessual() {
        return classeProcessual;
    }
    public void setClasseProcessual(String classeProcessual) {
        this.classeProcessual = classeProcessual;
    }
    public Nome getNome() {
        return nome;
    }
    public void setNome(Nome nome) {
        this.nome = nome;
    }
}

public void setId(int id) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o ID: ");
    this.id = scanner.nextInt();
    scanner.close();
}

public void setClasseProcessual(String classeProcessual) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite a classe processual: ");
    this.classeProcessual = scanner.nextLine();
    scanner.close();
}

public void setNome(Nome nome) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome: ");
    String nomeString = scanner.nextLine();
    this.nome = new Nome(nomeString);
    scanner.close();
}


// Método para obter o tipo de processo por ID (por exemplo, para uso em consultas)
public static TipoProcesso getTipoProcessoById(List<TipoProcesso> tiposProcessos, int id) {
    for (TipoProcesso tipoProcesso : tiposProcessos) {
        if (tipoProcesso.getId() == id) {
            return tipoProcesso;
        }
    }
    return null;
}