package br.com.backend.desafio5.desafio5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("java")
@RequestMapping("/java")
public class PersonController {
    private InMemoryDatabase database;

    @Autowired
    public PersonController(InMemoryDatabase database) {
        this.database = database;
    }

    @GetMapping("/people")
    public List<Person> listAllPeople() {
        return this.database.all();
    }

    @GetMapping("/people/{cpf}")
    public Person getPersonByCpf(@PathVariable("cpf") String cpf) {
        return database.byCpf(cpf).orElseThrow(() -> new ResourceNotFound());
    }

    @PostMapping("/people")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addPerson(@Valid @RequestBody PersonRequest person) throws CustomServerError {
        database.add(new Person(person.getCpf(), person.getName()));
    }

    @PutMapping("/people/{cpf}")
    public void update(@PathVariable("cpf") String cpf, @Valid @RequestBody PersonRequest request) {
        database.update(new Person(cpf, request.getName()));
    }

    @DeleteMapping("/people/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        database.delete(cpf);
    }


}
