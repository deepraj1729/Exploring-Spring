package com.deepraj1729.elasticsearchspringboot.service;

import com.deepraj1729.elasticsearchspringboot.document.Person;
import com.deepraj1729.elasticsearchspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public List<Person> findAll(){
        return (List<Person>) repository.findAll();
    }

    public Person findById(final String id){
        return repository.findById(id).orElse(null);
    }

    public void save(final Person person){
        repository.save(person);
    }

}


