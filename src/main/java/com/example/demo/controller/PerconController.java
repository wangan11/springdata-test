package com.example.demo.controller;//package com.wangan.springdata.controller;

import com.example.demo.entity.Person;
import com.example.demo.repostorty.PersonReposity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.example.demo.repostorty.AmbiguousUserRepository;

@RestController
@RequestMapping(value = "person")
public class PerconController {
    private Logger log=LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonReposity personRepository;
//    @Autowired
//    private PersonPageRepository personPageRepository;
//    @Autowired
//    private AmbiguousUserRepository ambiguousUserRepository;
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

    @GetMapping("getAll")
    @ResponseBody
    public Page<Person> findPersons(){
        Page<Person> all = personRepository.findAll(PageRequest.of(0, 10));
        List<Person> content = all.getContent();

        for (Person person :
                content) {
            log.info(person.toString());
        }
//        log.info("-----------");
//        List<Person> all1 = ambiguousUserRepository.findAll();
//        log.info(all1.toString());
        return  all;
    }

}
