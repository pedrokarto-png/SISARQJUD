public class Caixa {
    private int nroCaixa;
    private Processo processo;
    private String etiqueta;
    private String localizacao;
    private Date dataDesarquivamento;

    public Caixa() {}

public Caixa(int nroCaixa, Processo processo, String etiqueta, String localizacao, Date dataDesarquivamento) {
    this.nroCaixa = nroCaixa;
    this.processo = processo;
    this.etiqueta = etiqueta;
    this.localizacao = localizacao;
    this.dataDesarquivamento = dataDesarquivamento;
}

public int getNroCaixa() {
    return nroCaixa;
}

public void setNroCaixa(int nroCaixa) {
    this.nroCaixa = nroCaixa;
}

public Processo getProcesso() {
    return processo;
}

public void setProcesso(Processo processo) {
    this.processo = processo;
}

public String getEtiqueta() {
    return etiqueta;
}

public void setEtiqueta(String etiqueta) {
    this.etiqueta = etiqueta;
}

public String getLocalizacao() {
    return localizacao;
}

public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
}

public Date getDataDesarquivamento() {
    return dataDesarquivamento;
}

public void setDataDesarquivamento(Date dataDesarquivamento) {
    this.dataDesarquivamento = dataDesarquivamento;
}

private List<Parte> partes = new ArrayList<>();

public void adicionarParte(Parte parte) {
    partes.add(parte);
}

public void excluirParte(Parte parte) {
    partes.remove(parte);
}

public void vincularParte(Parte parteMae, Parte parteFilha) {
    parteMae.setParteMae(parteFilha);
    parteFilha.setParteFilha(parteMae);
}
    // Método para verificar se a caixa está ocupada
    public boolean isOcupada() {
        return processo != null;
    }
}