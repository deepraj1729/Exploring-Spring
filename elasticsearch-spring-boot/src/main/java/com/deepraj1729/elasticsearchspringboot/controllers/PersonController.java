package com.deepraj1729.elasticsearchspringboot.controllers;

import com.deepraj1729.elasticsearchspringboot.document.Person;
import com.deepraj1729.elasticsearchspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }


    @GetMapping("/")
    public List<Person>  getAllPerson(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable final String id){
        return service.findById(id);
    }


    @PostMapping("/")
    public void addPerson(@RequestBody final Person person){
        service.save(person);
    }

}
