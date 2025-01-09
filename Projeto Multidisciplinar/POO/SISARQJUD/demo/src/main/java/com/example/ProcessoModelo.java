package com.example;

import java.util.ArrayList;
import java.util.List;

public class ProcessoModelo {
    private int nroProcesso;
    private String varaOrigem;
    private TipoProcesso tipoProcesso;
    private String sigilo;
    private List<ParteModelo> partes;
    private String sentenca;
    private int volume;

    public enum Sigilo {
        PUBLICO, SIGILOSO, SECRETO
    }

    public enum TipoProcesso {
        CIVIL, PENAL, TRABALHISTA, FAMILIAR
    }

    public ProcessoModelo(int nroProcesso, String varaOrigem, TipoProcesso tipoProcesso, String sigilo, String sentenca, int volume) {
        if (varaOrigem == null || tipoProcesso == null || sigilo == null) {
            throw new IllegalArgumentException("Campos obrigatórios não podem ser nulos");
        }
        this.nroProcesso = nroProcesso;
        this.varaOrigem = varaOrigem;
        this.tipoProcesso = tipoProcesso;
        this.sigilo = sigilo;
        this.partes = new ArrayList<>();
        this.sentenca = sentenca;
        this.volume = volume;
    }

    public ProcessoModelo() {
        //TODO Auto-generated constructor stub
    }

    public ProcessoModelo(int numero, String varaOrigem2, String string, String string2, String sentenca2,
            int volume2) {
        //TODO Auto-generated constructor stub
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

    public TipoProcesso getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(TipoProcesso tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public String getSigilo() {
        return sigilo;
    }


    public List<ParteModelo> getPartes() {
        return partes;
    }

    public void setPartes(List<ParteModelo> partes) {
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
    public void adicionarParte(ParteModelo parte) {
        partes.add(parte);
    }

    // Método para remover uma parte
    public void removerParte(ParteModelo parte) {
        partes.remove(parte);
    }

    public String getDescricao() {
        return "Processo " + nroProcesso + " de tipo " + tipoProcesso + " na " + varaOrigem + " com sigilo " + sigilo;
    }

    public void setSigilo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSigilo'");
    }

    public void setTipoProcesso(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTipoProcesso'");
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
