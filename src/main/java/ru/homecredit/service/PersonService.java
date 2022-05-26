package ru.homecredit.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.homecredit.dao.entity.Person;

public interface PersonService {
    Mono<Person> getPersonById(Long id);

    Flux<Person> findAll();

    Mono<Person> save(Person person);
}
