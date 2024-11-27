public class Movimentacao {
    private int idMov;
    private Processo processo;
    private Funcionario responsavel;
    private String tipoMov;
    private Date data;

    
public Movimentacao() {}

public Movimentacao(int idMov, Processo processo, Funcionario responsavel, String tipoMov, Date data) {
    this.idMov = idMov;
    this.processo = processo;
    this.responsavel = responsavel;
    this.tipoMov = tipoMov;
    this.data = data;
}

public int getIdMov() {
    return idMov;
}

public void setIdMov(int idMov) {
    this.idMov = idMov;
}

public Processo getProcesso() {
    return processo;
}

public void setProcesso(Processo processo) {
    this.processo = processo;
}

public Funcionario getResponsavel() {
    return responsavel;
}

public void setResponsavel(Funcionario responsavel) {
    this.responsavel = responsavel;
}

public String getTipoMov() {
    return tipoMov;
}

public void setTipoMov(String tipoMov) {
    this.tipoMov = tipoMov;
}

public Date getData() {
    return data;
}

public void setData(Date data) {
    this.data = data;
}
    // Adicionar a movimentação à lista de movimentações do processo
    processo.getIdMov().add(this);
}