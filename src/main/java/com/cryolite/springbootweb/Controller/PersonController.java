package com.cryolite.springbootweb.Controller;

import com.cryolite.springbootweb.Dao.PersonRepository;
import com.cryolite.springbootweb.Model.Person;
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

import java.util.Optional;

@RestController
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;

    @GetMapping("createPerson")
    public ResponseEntity<String> createPerson(Person person) {
        logger.info("createPerson : Person = " + person.toString());
        ResponseEntity<String> responseEntity;
        try {
            personRepository.save(person);
            responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e)
        {
           responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("getPerson")
    public Optional<Person> getPerson(@RequestParam("id") int id){
        logger.info("getPerson : Id = "+ id);
        Optional<Person> person = personRepository.findById(id);
        return person;
    }
}

// The @Controller has been replaced by @RestController
// For @RequestMapping, @ResponseBody is not needed to be specified anymore.
// @RestController does the job of parsing and serializing objects for us.