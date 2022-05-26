package ru.homecredit.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.homecredit.dao.entity.Person;
import ru.homecredit.dao.repository.PersonRepository;
import ru.homecredit.service.PersonService;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public Mono<Person> getPersonById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Person> findAll(){
        return repository.findAll();
    }

    @SneakyThrows
    @Override
    public Mono<Person> save(Person person){
       return repository.save(person);
    }
}