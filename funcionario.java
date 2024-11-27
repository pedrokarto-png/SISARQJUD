public class Main {
    
    public static void main (String [] args){

        public class Funcionario {
            private int codVerificacao;
            private String nome;
            private Date dataNascimento;
            private String cargo;
        
           public Funcionario() {}
           
            public Funcionario(int codVerificacao, String nome, Date dataNascimento, String cargo) {
                this.codVerificacao = codVerificacao;
                this.nome = nome;
                this.dataNascimento = dataNascimento;
                this.cargo = cargo;
            }
           
            public int getCodVerificacao() {
                return codVerificacao;
            }
            public void setCodVerificacao(int codVerificacao) {
                this.codVerificacao = codVerificacao;
            }
            public String getNome() {
                return nome;
            }
            public void setNome(String nome) {
                this.nome = nome;
            }
            public Date getDataNascimento() {
                return dataNascimento;
            }
            public void setDataNascimento(Date dataNascimento) {
                this.dataNascimento = dataNascimento;
            }
            public String getCargo() {
                return cargo;
            }
            public void setCargo(String cargo) {
                this.cargo = cargo;
            }
    public boolean verificarAcesso(String codVerificacao) {
        return rfid.equals(rfidScaneado);
    }
}
    }
}
