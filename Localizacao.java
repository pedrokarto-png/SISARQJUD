import java.util.Scanner;

public class Localizacao extends caixa{
        private String estante;
        private Int prateleira;
        private Int Setor;
        public String getEstante() {
            return estante;
        }
        public void setEstante(String estante) {
            this.estante = estante;
        }
        public Int getPrateleira() {
            return prateleira;
        }
        public void setPrateleira(Int prateleira) {
            this.prateleira = prateleira;
        }
        public Int getSetor() {
            return Setor;
        }
        public void setSetor(Int setor) {
            Setor = setor;
        }
        public Localizacao(String estante, Int prateleira, Int setor) {
            this.estante = estante;
            this.prateleira = prateleira;
            Setor = setor;
        }
    Scanner scanner = new Scanner(System.in);

public void setEstante() {
    System.out.println("Digite a estante:");
    this.estante = scanner.nextLine();
}

public void setPrateleira() {
    System.out.println("Digite a prateleira:");
    this.prateleira = scanner.nextInt();
    scanner.nextLine();
}

public void setSetor() {
    System.out.println("Digite o setor:");
    this.Setor = scanner.nextInt();
    scanner.nextLine();
}

    }
