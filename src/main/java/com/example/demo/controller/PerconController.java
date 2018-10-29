package com.example.demo.controller;//package com.wangan.springdata.controller;

import com.example.demo.entity.Person;
import com.example.demo.repostorty.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "person")
public class PerconController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path = "addPerson")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        Person person=new Person();
        person.setId(id);
        personRepository.delete(person);
    }
}
