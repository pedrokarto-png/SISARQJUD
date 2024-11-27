import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parte {
    private String cpfCnpj;
    private String nome;
    private String nomeDoPai;
    private String nomeDaMae;
    private Endereco endereco;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String genero;
    private String tipoParte;
    private List<Parte> filhos = new ArrayList<>();


    public Parte(String cpfCnpj, String nome, String nomeDoPai, String nomeDaMae, Endereco endereco, LocalDate dataNascimento,
                 String naturalidade, String genero, String tipoParte) {
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte) {
        this.tipoParte = tipoParte;
    }

    public List<Parte> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Parte> filhos) {
        this.filhos = filhos;
    }
}