package br.com.backend.desafio5.desafio5;

public class Person {

    private String cpf;
    private String name;

    public Person(String  cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public  String  getCpf() {
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

    @Override
    public String toString() {
        return "Person [CPF:"  + cpf +
             " Name:" + name +"]";
    }
}
