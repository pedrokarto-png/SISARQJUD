import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processo {
    private int nroProcesso;
    private String varaOrigem;
    private String tipoProcesso;
    private String sigilo;
    private List<Parte> partes;
    private String sentenca;
    private int volume;

    public Processo() {
        partes = new ArrayList<>();
    }

    public Processo(int nroProcesso, String varaOrigem, String tipoProcesso, String sigilo, String sentenca, int volume) {
        this.nroProcesso = nroProcesso;
        this.varaOrigem = varaOrigem;
        this.tipoProcesso = tipoProcesso;
        this.sigilo = sigilo;
        this.partes = new ArrayList<>();
        this.sentenca = sentenca;
        this.volume = volume;
    }
    public int getNroProcesso() {
        return nroProcesso;
    }
    public void setNroProcesso(int nroProcesso) {
        this.nroProcesso = nroProcesso;
    }
    public String getVaraOrigem() {
        return varaOrigem;
    }
    public void setVaraOrigem(String varaOrigem) {
        this.varaOrigem = varaOrigem;
    }
    public String getTipoProcesso() {
        return tipoProcesso;
    }
    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }
    public String getSigilo() {
        return sigilo;
    }
    public void setSigilo(String sigilo) {
        this.sigilo = sigilo;
    }
    public List<Parte> getPartes() {
        return partes;
    }
    public void setPartes(List<Parte> partes) {
        this.partes = partes;
    }
    public String getSentenca() {
        return sentenca;
    }
    public void setSentenca(String sentenca) {
        this.sentenca = sentenca;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    // Método para adicionar uma parte ao processo
    public void adicionarParte(Parte parte) {
        partes.add(parte);
    }
     // Método para realizar uma movimentação
     // (exemplo: arquivamento)
    public void realizarMovimentacao(String tipoMovimentacao, Funcionario funcionario, String data) {
        // Lógica para realizar a movimentação
        System.out.println("Processo " + nroProcesso + " movimentado para " + tipoMovimentacao + " por " + funcionario.getNome() + " em " + data);
    }

    // Método de busca
    // (exemplo: por número do processo)
    public static Processo buscarProcessoPorNumero(List<Processo> processos, int numeroProcesso) {
        for (Processo processo : processos) {
            if (processo.getNroProcesso() == numeroProcesso) {
                return processo;
            }
        }
        return null;
    }
}