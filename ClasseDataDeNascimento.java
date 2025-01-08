import java.util.Scanner;
import java.util.Date;

public class ClasseDataDeNascimento extends Parte {
    private Date dataDeNascimento;

    public ClasseDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a data de nascimento (no formato dd/mm/yyyy):");
        String dataInput = scanner.nextLine();
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataDeNascimento = format.parse(dataInput);
            ClasseDataDeNascimento obj = new ClasseDataDeNascimento(dataDeNascimento);
            System.out.println("Data de nascimento armazenada: " + obj.getDataDeNascimento());
        } catch (ParseException e) {
            System.out.println("Formato de data inválido.");
        }
    }
}
