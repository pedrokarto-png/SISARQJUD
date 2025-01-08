import java.util.Scanner;

public static class Endereco extends Parte {
    private String cep;
    private String rua;
    private int numero;
    private String complemento;

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco(String cep, String rua, int numero, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
Scanner scanner = new Scanner(System.in);

public Endereco() {
    System.out.print("Digite o CEP: ");
    this.setCep(scanner.nextLine());
    System.out.print("Digite o nome da rua: ");
    this.setRua(scanner.nextLine());
    System.out.print("Digite o número: ");
    this.setNumero(scanner.nextInt());
    scanner.nextLine();
    System.out.print("Digite o complemento (opcional): ");
    String complemento = scanner.nextLine();
    if (!complemento.isEmpty()) {
        this.setComplemento(complemento);
    }
}
    public String formatarEndereco() {
        return rua + ", " + numero + (complemento != null && !complemento.isEmpty() ? " - " + complemento : "") + " - " + cep;
    }
}