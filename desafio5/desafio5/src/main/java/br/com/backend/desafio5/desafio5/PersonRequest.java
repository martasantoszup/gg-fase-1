package br.com.backend.desafio5.desafio5;

import javax.validation.constraints.NotBlank;
public class PersonRequest {

    @NotBlank
    private String cpf;
    @NotBlank
    private  String name;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
