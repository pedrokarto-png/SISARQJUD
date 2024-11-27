import java.util.Scanner;

public class Telefone extends Parte{
    private String ddd;
    private String numero;

    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }
public Telefone() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o DDD: ");
    this.setDdd(scanner.nextLine());
    System.out.print("Digite o número: ");
    this.setNumero(scanner.nextLine());
}
}
