package ru.homecredit.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.homecredit.dao.entity.Person;
import ru.homecredit.service.PersonService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @GetMapping("/persons/{id}")
    public Mono<Person> getPerson(@PathVariable("id") Long id) {
        return service.getPersonById(id);
    }

    @GetMapping("/persons")
    public Flux<Person> getAllPersons() {
        return service.findAll();
    }

    @PostMapping("/persons")
    public Mono<Person> postPerson(@RequestBody Person person) {
       return service.save(person);
    }
}
