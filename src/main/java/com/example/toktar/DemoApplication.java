package com.example.toktar;
import controllers.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }



    private List<Person> people = Arrays.asList(
            new Person(1, "Aisultan Omarbek", 30),
            new Person(2, "Roza Dikhanbaeva", 25),
            new Person(3, "Aruzhan Mahabbat", 25),
            new Person(4, "Zhanbirbay Zhigitali", 25),
            new Person(5, "Toktar Sultan", 25)

            );
    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPeople() {
        return ResponseEntity.ok(people);
    }
    @GetMapping("url")
    public String url(){
        return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) {
        Person person = people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}