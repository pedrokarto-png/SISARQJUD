package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataDeNascimentoModelo {

    private Date dataDeNascimento;

    public DataDeNascimentoModelo(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public DataDeNascimentoModelo() {
        //TODO Auto-generated constructor stub
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    // Método utilitário para converter String em Date
    public static Date converterStringParaData(String dataInput) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(dataInput);
    }

    // Método utilitário para exibir o objeto de forma legível
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return "Data de nascimento: " + format.format(dataDeNascimento);
    }

    public void setId(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
