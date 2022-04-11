package models;

import utils.CPFUtil;

import java.text.ParseException;

public class Pessoa {
    public String nome;
    private final String cpf;
    private String email;

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String cpfFormatado() throws ParseException {
        return CPFUtil.formater(cpf);
    }

//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
