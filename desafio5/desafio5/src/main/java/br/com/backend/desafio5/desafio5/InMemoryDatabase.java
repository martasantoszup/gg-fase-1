package br.com.backend.desafio5.desafio5;

import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class InMemoryDatabase {

    private static final Map<String, Person> database = new HashMap<>();

    static {
        database.put("11111",new Person("11111", "Marta") );
        database.put("22222",new Person("22222", "Jamile") );
        database.put("33333",new Person("33333", "Thais") );

    }

    public List<Person>all(){
        return new ArrayList<>(database.values());
    }

    public Optional<Person> byCpf(String cpf) {
        return Optional.ofNullable(database.get(cpf));
    }

    public String add(Person person) {
        database.put(person.getCpf(), person);
        return person.getCpf();
    }

    public void update(Person person) {
        if(database.get(person.getCpf()) != null) {
            database.put(person.getCpf(), person);
        } else {
            throw new ResourceNotFound();
        }
    }

    public void delete(String cpf) {
        if(database.get(cpf) != null) {
            database.remove(cpf);
        } else {
            throw new ResourceNotFound();
        }
    }
}
