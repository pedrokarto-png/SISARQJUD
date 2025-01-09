package com.example;

import java.io.File;
import java.util.Date;

public class MovimentacaoModelo {
    private int idMov;
    private ProcessoModelo processo;
    private FuncionarioModelo responsavel;
    private String tipoMov;
    private Date data;

    public MovimentacaoModelo(int idMov, ProcessoModelo processo, FuncionarioModelo responsavel, String tipoMov, Date data) {
        this.idMov = idMov;
        this.processo = processo;
        this.responsavel = responsavel;
        this.tipoMov = tipoMov;
        this.data = data;
    }

    public MovimentacaoModelo(String idMov) {
        this.idMov = Integer.parseInt(idMov);
    }

    public MovimentacaoModelo(ProcessoModelo processo, FuncionarioModelo responsavel, String tipoMov, Date data) {
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

    public ProcessoModelo getProcesso() {
        return processo;
    }

    public void setProcesso(ProcessoModelo processo) {
        this.processo = processo;
    }

    public FuncionarioModelo getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(FuncionarioModelo responsavel) {
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

    // Método para upload de documentos
    public void uploadDocumento(File documento) {
        String nomeArquivo = documento.getName();
        if (nomeArquivo.endsWith(".pdf") || nomeArquivo.endsWith(".xlsx") || nomeArquivo.endsWith(".txt")) {
            System.out.println("Documento '" + nomeArquivo + "' carregado com sucesso.");
        } else {
            System.out.println("Formato de arquivo inválido. Aceitos: PDF, XLSX, TXT.");
        }
    }
}
