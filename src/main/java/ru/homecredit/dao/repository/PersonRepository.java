package ru.homecredit.dao.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.homecredit.dao.entity.Person;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}
