import java.util.Scanner;

public class ID extends movimentação {
    public Double ID;

    public ID(Double iD) {
        ID = iD;
    }

    public Double getID() {
        return ID;
    }

    public void setID(Double iD) {
        ID = iD;
    }
    public Scanner scanner = new Scanner(System.in);

    public void setIDFromUser() {
        System.out.println("Digite o ID:");
        ID = scanner.nextDouble();
    }
}

