package ru.homecredit.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    Long id;
    String firstname;
    String lastname;
    String patronymic;
}
