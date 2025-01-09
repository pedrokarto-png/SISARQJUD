package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaixaModelo {
    private int nroCaixa;
    private ProcessoModelo processo;
    private String etiqueta;
    private String localizacao;
    private Date dataDesarquivamento;
    private List<ParteModelo> partes = new ArrayList<>();

    public CaixaModelo() {}

    // Construtor com parâmetros
    public CaixaModelo(int nroCaixa, ProcessoModelo processo, String etiqueta, String localizacao, Date dataDesarquivamento) {
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

    public ProcessoModelo getProcesso() {
        return processo;
    }

    public void setProcesso(ProcessoModelo processo) {
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

    public List<ParteModelo> getPartes() {
        return partes;
    }

    public void adicionarParte(ParteModelo parte) {
        partes.add(parte);
    }

    @SuppressWarnings("unlikely-arg-type")
    public void excluirParte(CharSequence parte) {
        partes.remove(parte);
    }

    public boolean isOcupada() {
        return processo != null;
    }

    public String getParte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getParte'");
    }

    public void adicionarParte(String parte) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarParte'");
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void setOcupada(boolean boolean1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOcupada'");
    }
}
