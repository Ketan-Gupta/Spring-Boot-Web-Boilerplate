package com.cryolite.springbootweb.Controller;

import com.cryolite.springbootweb.Dao.PersonRepository;
import com.cryolite.springbootweb.Model.Person;
import com.cryolite.springbootweb.Service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("createPerson")
    public Boolean createPerson(Person person) {
        logger.info("createPerson : Person = " + person.toString());
        return personService.createPerson(person);
    }

    @GetMapping("getPersonById")
    public Optional<Person> getPerson(@RequestParam("id") int id){
        logger.info("getPerson : Id = "+ id);
        return personService.getPersonById(id);
    }

    @GetMapping("getPersonByName")
    public Person getPerson(@RequestParam("name") String name){
        logger.info("getPerson : name = "+ name);
        return personService.getPersonByName(name);
    }

    @GetMapping("extractAllPersons")
    public List<Person> extractPerson(){
        logger.info("extractAllPersons");
        return personService.extractAllPersons();
    }
}

// The @Controller has been replaced by @RestController
// For @RequestMapping, @ResponseBody is not needed to be specified anymore.
// @RestController does the job of parsing and serializing objects for us.